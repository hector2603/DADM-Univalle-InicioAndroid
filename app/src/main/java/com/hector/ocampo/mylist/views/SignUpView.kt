package com.hector.ocampo.miprimerapp.views

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NavUtils
import com.hector.ocampo.mylist.databinding.SignUpBinding


class SignUpView : AppCompatActivity(){

    private lateinit var binding: SignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(this::class.java.simpleName,"Empezó la creación de la vista de crear cuenta")
        super.onCreate(savedInstanceState)
        binding = SignUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.createAccount.setOnClickListener{
                view -> val toast = Toast.makeText(applicationContext, "hello ${binding.userTI.editText?.text} your password is ${binding.passwordTI.editText?.text}", Toast.LENGTH_SHORT)
            toast.show()
        }

        binding.iniciarSesionButton.setOnClickListener{
                view -> NavUtils.navigateUpFromSameTask(this)
        }

    }


}