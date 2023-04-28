package com.hector.ocampo.mylist.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat

class LoginViewRClass : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
/*        setContentView(R.layout.login_constrains)

        val button = findViewById<Button>(R.id.filledButton)
        val user = findViewById<TextInputLayout>(R.id.userTI)
        val password = findViewById<TextInputLayout>(R.id.passwordTI)

        button.setOnClickListener { view ->
            val toast = Toast.makeText(applicationContext, "hello ${user.getEditText()?.getText()} your password is ${password.getEditText()?.getText()}", Toast.LENGTH_SHORT)
            toast.show()
        }*/
    }
}