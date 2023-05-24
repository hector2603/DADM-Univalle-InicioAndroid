package com.hector.ocampo.mylist.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.ui.setupActionBarWithNavController
import com.hector.ocampo.mylist.R
import com.hector.ocampo.mylist.databinding.MainContainerBinding
import com.hector.ocampo.mylist.views.search.SearchMovieView

class MainContainerView : AppCompatActivity() {

    private lateinit var binding: MainContainerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = MainContainerBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.perfilF, R.id.terminadasF, R.id.actualesF, R.id.pendientesF
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        binding.searchMovie.setOnClickListener {
            view -> val intent = Intent(this, SearchMovieView::class.java)
            startActivity(intent)
        }
    }

}