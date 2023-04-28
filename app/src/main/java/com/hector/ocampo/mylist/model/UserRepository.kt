package com.hector.ocampo.mylist.model

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.hector.ocampo.mylist.model.AppDatabase
import com.hector.ocampo.mylist.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository(applicationContext: Context) {
    private val userDao = AppDatabase.getInstance(applicationContext).userDao()

    fun findByEmail(email: String): User {
        return userDao.findByEmail(email)
    }

    fun findByUser(user: String): User? {
        return userDao.findByUser(user)
    }

    fun createUser(user: User){
        userDao.insert(user)
    }

    fun getAll(): List<User> {
        return userDao.getAll()
    }

}