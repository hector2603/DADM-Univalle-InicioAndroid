package com.hector.ocampo.mylist.model

import android.content.Context

class HistoryMovieSearchedRepository(applicationContext: Context) {
    private val historyMovieSearchedDaoDato = AppDatabase.getInstance(applicationContext).historyMovieSearchedDaoDato()

    fun getAll(): List<HistoryMovieSearched> {
        return historyMovieSearchedDaoDato.getAll()
    }

    fun createHistory(historyMovieSearched: HistoryMovieSearched){
        historyMovieSearchedDaoDato.insert(historyMovieSearched)
    }
}