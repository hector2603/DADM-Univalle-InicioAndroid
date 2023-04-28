package com.hector.ocampo.miprimerapp.presenter

import android.content.Context
import android.util.Log

import com.hector.ocampo.miprimerapp.model.UserRepository
import com.hector.ocampo.miprimerapp.views.LoginView

class LoginPresenter(private var loginView: LoginView, applicationContext: Context){

    private var userRepository = UserRepository(applicationContext)

    fun login(user: String, password: String ) {
        //val userToLogin = userRepository.findByEmail("h@h.com")
        if(true){
            Log.d(this::class.java.simpleName,"Entro al Presenter.Login")
            loginView.changeViewToHome()
        }
    }

    /*fun initDataBase(){
        liveData(context =   Dispatchers.IO) {
            userRepository.createUser(User(0,"h@h.com", "hector2603", "1234"))
            userRepository.getAll().let {
                Log.d(this::class.java.simpleName, it.toString())
            }
            emit(userRepository.getAll())
        }
    }*/


}

