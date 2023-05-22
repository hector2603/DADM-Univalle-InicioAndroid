package com.hector.ocampo.mylist.model

import android.content.Context

class CurrentMoviesRepository(applicationContext: Context) {
    private val currentMoviesDao = AppDatabase.getInstance(applicationContext).currentMoviesDato()

    fun getAll(): List<CurrentMovies> {
        return currentMoviesDao.getAll()
    }

    fun createCurrentMovieUser(currentmovies: CurrentMovies){
        currentMoviesDao.insert(currentmovies)
    }
}