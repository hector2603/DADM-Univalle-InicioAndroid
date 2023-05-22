package com.hector.ocampo.mylist.views.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hector.ocampo.mylist.databinding.FragmentActualesBinding
import com.hector.ocampo.mylist.model.CurrentMovies
import com.hector.ocampo.mylist.presenter.CurrentMoviesPresenter
import com.hector.ocampo.mylist.views.main.list.ListView

class ActualesView : Fragment(){

    private var _binding: FragmentActualesBinding? = null
    private lateinit var currentMoviesPresenter: CurrentMoviesPresenter

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentActualesBinding.inflate(inflater, container, false)
        val applicationContext = requireContext().applicationContext
        currentMoviesPresenter = CurrentMoviesPresenter(this, applicationContext)
        currentMoviesPresenter.chargeMovies()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    fun chargeMovies(movies: List<CurrentMovies>){
        val recyclerView: RecyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext().applicationContext)
        val adapter = ListView(movies,requireContext().applicationContext)
        recyclerView.adapter = adapter
    }

}