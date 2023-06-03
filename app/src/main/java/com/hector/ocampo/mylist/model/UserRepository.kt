package com.hector.ocampo.mylist.model

import android.content.Context

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