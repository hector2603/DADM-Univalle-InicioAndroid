package com.hector.ocampo.mylist.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface  UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>
    @Query("SELECT * FROM user WHERE email = :email LIMIT 1")
    fun findByEmail(email: String): User
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)
    @Delete
    fun delete(user: User)
    @Query("SELECT * FROM user WHERE user = :user LIMIT 1")
    fun findByUser(user: String): User?
}