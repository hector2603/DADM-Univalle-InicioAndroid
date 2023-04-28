package com.hector.ocampo.mylist.presenter

import android.content.Context
import android.util.Log
import com.hector.ocampo.mylist.model.User
import com.hector.ocampo.mylist.model.UserRepository
import com.hector.ocampo.mylist.views.SignUpView
import java.util.concurrent.Executors
import java.util.concurrent.FutureTask

class SignUpPresenter(private var signUpView: SignUpView, applicationContext: Context) {

    private var userRepository = UserRepository(applicationContext)

    fun signUp(user:String, email:String, password:String){
        Log.d(this::class.java.simpleName,"Entro a SignUpPresenter.signUp")
        val futureTask = FutureTask Callable@{
            userRepository.createUser(User(0,email,user,password))
        }
        val executorService = Executors.newSingleThreadExecutor()
        executorService.execute(futureTask)
        Log.d(this::class.java.simpleName,"El usuario creó la cuenta correctamente")
        signUpView.changeViewToLogin()
    }

}