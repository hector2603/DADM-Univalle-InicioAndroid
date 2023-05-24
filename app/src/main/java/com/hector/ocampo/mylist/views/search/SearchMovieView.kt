package com.hector.ocampo.mylist.views.search

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hector.ocampo.mylist.databinding.SearchMovieBinding
import com.hector.ocampo.mylist.model.CurrentMovies
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
            searchMovie(binding.searchContainer.text.toString())
            false
        }

        binding.time.setOnClickListener { view ->
            binding.searchBar.setText("Time")
            binding.searchContainer.hide()
            searchMovie(binding.searchContainer.text.toString())
        }

    }

    fun chargeMovies(movies: List<CurrentMovies>){
        val recyclerView: RecyclerView = binding.searchRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        val adapter = ListView(movies, applicationContext)
        recyclerView.adapter = adapter
    }

    fun searchMovie(movieQuery: String){
        lifecycleScope.launch(Dispatchers.IO) {
            val searchedMovies = searchMoviesPresenter.chargeMovies(movieQuery)
            runOnUiThread {
                chargeMovies(searchedMovies)
            }
        }
    }



}