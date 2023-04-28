package com.hector.ocampo.miprimerapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val email: String,
    @ColumnInfo(name = "user") val user: String,
    @ColumnInfo(name = "password") val password: String
)
