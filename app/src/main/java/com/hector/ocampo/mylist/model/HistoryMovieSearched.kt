package com.hector.ocampo.mylist.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="history_movie")
data class HistoryMovieSearched(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val text: String,
)
