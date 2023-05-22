package com.hector.ocampo.mylist.presenter

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.liveData
import com.hector.ocampo.mylist.model.CurrentMovies
import com.hector.ocampo.mylist.model.CurrentMoviesRepository
import com.hector.ocampo.mylist.model.User

import com.hector.ocampo.mylist.model.UserRepository
import com.hector.ocampo.mylist.views.LoginView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Executors
import java.util.concurrent.FutureTask

class LoginPresenter(private var loginView: LoginView, applicationContext: Context){

    private var userRepository = UserRepository(applicationContext)
    private var currentMoviesRepository = CurrentMoviesRepository(applicationContext)

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

    fun initDataBase(){
        Log.d(this::class.java.simpleName,"Entro al Presenter.initDataBase")
        val futureTask = FutureTask Callable@{
            val allMovies = currentMoviesRepository.getAll()
            Log.d(this::class.java.simpleName, "cantidad de peliculas en la base de datos: ${allMovies.size}")
            if(allMovies.isEmpty()){
                currentMoviesRepository.createCurrentMovieUser(CurrentMovies(0, "Toy Story", "Los juguetes de Andy un niÃ±o de seis aÃ±os temen que haya llegado su hora y que un nuevo regalo de cumpleaÃ±os les sustituya en el corazÃ³n de su dueÃ±o. Woody un vaquero que ha sido hasta ahora el juguete favorito de Andy trata de tranquili", "https://image.tmdb.org/t/p/w500/GdMDcacJra4ZmDaBIRASIpzjmU.jpg"))
                currentMoviesRepository.createCurrentMovieUser(CurrentMovies(0, "Jumanji", "Alan Parris queda atrapado en un juego de mesa mÃ¡gico y muy antiguo Jumanji durante 25 aÃ±os. Cuando finalmente es liberado por dos niÃ±os una manada de animales exÃ³ticos tambiÃ©n es liberada. Alan deberÃ¡ salvar a su pueblo de la destrucciÃ³n.", "https://image.tmdb.org/t/p/w500/m67M2wXLKblJLuJlvF7qaGrGfCa.jpg"))
                currentMoviesRepository.createCurrentMovieUser(CurrentMovies(0, "Casper", "La seÃ±ora Crittenden contrata al doctor Harvey para que libere la mansiÃ³n de Whipstaff de los cuatro fantasmas que la habitan. LÃ¡tigo Tufo y Gordy no toleran a los mortales dentro de la casa y tienen un sentido del humor tan negro que ahuyenta a los mÃ¡s atrevidos. Su sobrino Casper en cambio es un joven amistoso que estÃ¡ harto de sus tÃ\u00ADos. Harvey se presenta en la mansiÃ³n con su hija Kat una soÃ±adora adolescente. Ella y Casper simpatizan inmediatamente a pesar de que ambos tienen problemas para relacionarse. De Casper huye todo el mundo porque es un fantasma y de Kat en cuanto se enteran de la profesiÃ³n de su padre. El fantasma y la joven son dos almas gemelas que entran en continuo conflicto con sus respectivos parientes por cualquier cosa.", "https://image.tmdb.org/t/p/w500/2ah8fNJFZVU3vcXhU5xfAYi2eym.jpg"))
                currentMoviesRepository.createCurrentMovieUser(CurrentMovies(0, "Super Mario Bros.", "Basada en el famoso videojuego de la compaÃ±Ã\u00ADa Nintendo. Dos hermanos fontaneros se adentran en un mundo paralelo para salvar a la princesa Daisy de las garras del rey Koopa y su ejÃ©rcito de reptiles.", "https://image.tmdb.org/t/p/w500/oU2oB6NWnMJBkHwzRXQYgLAnJ8v.jpg"))
            }
            return@Callable "Resultado de la tarea"
        }
        val executorService = Executors.newSingleThreadExecutor()
        executorService.execute(futureTask)
        val result = futureTask.get()
        Log.d(this::class.java.simpleName, result)
    }


}

