package com.hector.ocampo.mylist.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface HistoryMovieSearchedDao {
    @Query("SELECT * FROM history_movie ORDER BY id DESC")
    fun getAll(): List<HistoryMovieSearched>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(historyMovieSearched: HistoryMovieSearched)
}