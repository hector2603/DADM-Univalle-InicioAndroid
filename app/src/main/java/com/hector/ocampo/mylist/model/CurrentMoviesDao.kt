package com.hector.ocampo.mylist.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CurrentMoviesDao {
    @Query("SELECT * FROM current_movies")
    fun getAll(): List<CurrentMovies>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(currentMovies: CurrentMovies)
}