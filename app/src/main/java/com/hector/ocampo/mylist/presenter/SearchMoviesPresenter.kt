package com.hector.ocampo.mylist.presenter

import android.content.Context
import com.hector.ocampo.mylist.R
import com.hector.ocampo.mylist.model.CurrentMovies
import com.hector.ocampo.mylist.model.HistoryMovieSearched
import com.hector.ocampo.mylist.model.HistoryMovieSearchedRepository
import com.hector.ocampo.mylist.model.api.RetroFitHelper
import com.hector.ocampo.mylist.views.search.SearchMovieView


class SearchMoviesPresenter(private var searchMovieView : SearchMovieView, var applicationContext: Context) {

    val retrofit = RetroFitHelper.getInstance()
    private var historyMovieSearchedRepository = HistoryMovieSearchedRepository(applicationContext)


    suspend fun chargeMovies(movieQuery: String): List<CurrentMovies>{
        val movies = retrofit.getMovies(movieQuery = movieQuery, apiKey = applicationContext.getString(R.string.apiKeytmdb))
        val currentMovies = movies.body()?.results?.map { movie ->
            val posterPath = if (movie.poster_path != null) {
                "https://image.tmdb.org/t/p/w500/${movie.poster_path}"
            } else {
                "https://motivatevalmorgan.com/wp-content/uploads/2016/06/default-movie.jpg"
            }
            CurrentMovies(movie.id, movie.title, movie.overview, posterPath)
        } ?: emptyList()
        return currentMovies
    }

    fun saveHistory(historyTittle: String){
        historyMovieSearchedRepository.createHistory(HistoryMovieSearched(0, historyTittle))
    }

    fun getAllHistory(): List<HistoryMovieSearched>{
        return historyMovieSearchedRepository.getAll()
    }
}