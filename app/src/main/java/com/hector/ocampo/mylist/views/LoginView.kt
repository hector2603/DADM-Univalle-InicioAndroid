package com.hector.ocampo.mylist.views

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.hector.ocampo.mylist.databinding.LoginConstrainsBinding
import com.hector.ocampo.mylist.presenter.LoginPresenter


class LoginView : AppCompatActivity(){

    private lateinit var binding: LoginConstrainsBinding
    private lateinit var loginPresenter: LoginPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = LoginConstrainsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        loginPresenter = LoginPresenter(this, applicationContext)
        loginPresenter.initDataBase()
        binding.filledButton.setOnClickListener{
            view ->
            Log.d(this::class.java.simpleName,"Entró a Iniciar sesión")
            loginPresenter.login(binding.userTI.editText?.text.toString(), binding.passwordTI.editText?.text.toString())
        }
        binding.createAccountButton.setOnClickListener{
            view -> val intent = Intent(this, SignUpView::class.java)
            startActivity(intent)
        }
    }
    fun changeViewToHome(){
        val intent = Intent(this, MainContainerView::class.java)
        startActivity(intent)
    }

}