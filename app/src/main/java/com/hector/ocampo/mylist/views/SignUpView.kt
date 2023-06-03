package com.hector.ocampo.mylist.views

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NavUtils
import com.hector.ocampo.mylist.databinding.SignUpBinding
import com.hector.ocampo.mylist.presenter.SignUpPresenter


class SignUpView : AppCompatActivity(){

    private lateinit var binding: SignUpBinding
    private lateinit var signUpPresenter: SignUpPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(this::class.java.simpleName,"Empezó la creación de la vista de crear cuenta")
        super.onCreate(savedInstanceState)
        binding = SignUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        signUpPresenter = SignUpPresenter(this, applicationContext)
        binding.createAccount.setOnClickListener{
            view -> signUpPresenter.signUp( binding.userTI.editText?.text.toString(), binding.emailTI.editText?.text.toString(), binding.passwordTI.editText?.text.toString())
        }
        binding.iniciarSesionButton.setOnClickListener{
                view -> NavUtils.navigateUpFromSameTask(this)
        }
    }
    fun  changeViewToLogin(){
        NavUtils.navigateUpFromSameTask(this)
    }
}