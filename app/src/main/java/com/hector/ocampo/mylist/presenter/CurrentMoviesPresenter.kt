package com.hector.ocampo.mylist.presenter

import android.content.Context
import androidx.fragment.app.Fragment
import com.hector.ocampo.mylist.model.CurrentMoviesRepository
import com.hector.ocampo.mylist.views.LoginView
import com.hector.ocampo.mylist.views.main.ActualesView
import java.util.concurrent.Executors
import java.util.concurrent.FutureTask

class CurrentMoviesPresenter (private var actualesView : ActualesView, applicationContext: Context) {

    private var currentMoviesRepository = CurrentMoviesRepository(applicationContext)

    fun chargeMovies(){
        val futureTask = FutureTask Callable@{
            val userToLogin = currentMoviesRepository.getAll()
            return@Callable userToLogin
        }
        val executorService = Executors.newSingleThreadExecutor()
        executorService.execute(futureTask)
        actualesView.chargeMovies(futureTask.get())
    }

}