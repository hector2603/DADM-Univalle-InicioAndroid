package com.hector.ocampo.mylist.presenter

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.liveData
import com.hector.ocampo.mylist.model.User

import com.hector.ocampo.mylist.model.UserRepository
import com.hector.ocampo.mylist.views.LoginView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Executors
import java.util.concurrent.FutureTask

class LoginPresenter(private var loginView: LoginView, applicationContext: Context){

    private var userRepository = UserRepository(applicationContext)

    fun login(user: String, password: String ) {
        Log.d(this::class.java.simpleName,"Entro al Presenter.Login")
        val futureTask = FutureTask Callable@{
            val userToLogin = userRepository.findByUser(user)
            userToLogin?.let { value ->
                return@Callable value.password == password
            } ?: return@Callable false
        }
        val executorService = Executors.newSingleThreadExecutor()
        executorService.execute(futureTask)
        val result = futureTask.get()

        if(result){
            Log.d(this::class.java.simpleName,"El usuario se logueó correctamente")
            loginView.changeViewToHome()
        }else{
            Toast.makeText(loginView, "Datos Incorrecto o el usuario no existe", Toast.LENGTH_SHORT).show()
        }
    }

    /*fun initDataBase(){

        val futureTask = FutureTask Callable@{
            val allUsers = userRepository.getAll()
            for (user in allUsers) {
                Log.d("User", "User: ${user.user}, ${user.email}, ${user.password}")
            }
            Log.d(this::class.java.simpleName, "cantidad de usuarios: ${allUsers.size}")

            //userRepository.createUser(User(0, "h@h.com", "hector2603", "1234"))
            return@Callable "Resultado de la tarea"
        }
        val executorService = Executors.newSingleThreadExecutor()
        executorService.execute(futureTask)
        val result = futureTask.get()
        Log.d(this::class.java.simpleName, result)
    }*/


}

