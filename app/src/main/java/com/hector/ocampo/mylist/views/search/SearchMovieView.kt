package com.hector.ocampo.mylist.views.search

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.search.SearchView
import com.hector.ocampo.mylist.databinding.SearchMovieBinding
import com.hector.ocampo.mylist.model.CurrentMovies
import com.hector.ocampo.mylist.model.HistoryMovieSearched
import com.hector.ocampo.mylist.presenter.SearchMoviesPresenter
import com.hector.ocampo.mylist.views.main.list.ListView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class SearchMovieView : AppCompatActivity(){
    private lateinit var binding: SearchMovieBinding
    private lateinit var searchMoviesPresenter: SearchMoviesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SearchMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        searchMoviesPresenter = SearchMoviesPresenter(this, applicationContext)

        binding.searchContainer.editText.setOnEditorActionListener { textView, i, keyEvent ->
            Log.d(this::class.simpleName.toString(), binding.searchContainer.getText().toString())
            binding.searchBar.setText(binding.searchContainer.getText())
            binding.searchContainer.hide()
            saveHistory(binding.searchBar.text.toString())
            searchMovie(binding.searchContainer.text.toString())
            false
        }

        binding.searchContainer.addTransitionListener { searchView, previousState, newState ->
            if (newState == SearchView.TransitionState.SHOWING) {
                Log.d(this::class.simpleName.toString(), "Se abrió la ventana de busqueda")
                binding.searchContainer.setText("")
                binding.searchBar.setText("")
                chargeHistory()
            }
        }

    }

    fun chargeMovies(movies: List<CurrentMovies>){
        val recyclerView: RecyclerView = binding.searchRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        val adapter = ListView(movies, applicationContext)
        recyclerView.adapter = adapter
    }

    fun chargeHistoryRecyclerView(history: List<HistoryMovieSearched>){
        val recyclerView: RecyclerView = binding.historyRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        val adapter = ItemSearch(history)
        recyclerView.adapter = adapter
        adapter.setOnClickListener(object :
            ItemSearch.OnClickListener {
            override fun onClick(position: Int, history: HistoryMovieSearched) {
                Log.d(this::class.simpleName.toString(), "Se seleccionó el item del historial ${history.text}")
                binding.searchBar.setText(history.text)
                binding.searchContainer.hide()
                searchMovie(binding.searchBar.text.toString())
            }
        })
    }

    fun searchMovie(movieQuery: String){
        lifecycleScope.launch(Dispatchers.IO) {
            val searchedMovies = searchMoviesPresenter.chargeMovies(movieQuery)
            runOnUiThread {
                chargeMovies(searchedMovies)
            }
        }
    }

    fun chargeHistory(){
        lifecycleScope.launch(Dispatchers.IO) {
            val history = searchMoviesPresenter.getAllHistory()
            runOnUiThread {
                chargeHistoryRecyclerView(history)
            }
        }
    }

    fun saveHistory(history: String){
        lifecycleScope.launch(Dispatchers.IO) {
            searchMoviesPresenter.saveHistory(history)
        }
    }



}