package com.hector.ocampo.miprimerapp.model

import android.content.Context
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository(applicationContext: Context) {
    private val userDao = AppDatabase.getInstance(applicationContext).userDao()

    fun findByEmail(email: String): LiveData<User> {
        return userDao.findByEmail(email)
    }

    suspend fun createUser(user: User){
        withContext(Dispatchers.IO) {
            userDao.insertAll(user)
        }
    }

    fun getAll(): LiveData<List<User>> {
        return userDao.getAll()
    }

}