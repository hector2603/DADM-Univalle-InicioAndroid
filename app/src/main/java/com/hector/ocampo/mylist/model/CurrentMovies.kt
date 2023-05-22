package com.hector.ocampo.mylist.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="current_movies")
data class CurrentMovies(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val synopsis: String,
    val image: String
)
