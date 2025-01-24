package com.ejemplo.medidorapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.ejemplo.medidorapp.data.AppDatabase
import com.ejemplo.medidorapp.navigation.AppNavGraph
import com.ejemplo.medidorapp.repository.LecturaRepository
import com.ejemplo.medidorapp.ui.LecturaViewModel
import com.ejemplo.medidorapp.ui.LecturaViewModelFactory

class   MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Crea la base de datos
        val db = AppDatabase.getDatabase(this)

        // 2. Crea repositorio
        val repo = LecturaRepository(db.lecturaDao())

        // 3. Crea ViewModel a través de Factory
        val viewModelFactory = LecturaViewModelFactory(repo)
        val lecturaViewModel = ViewModelProvider(this, viewModelFactory)
            .get(LecturaViewModel::class.java)

        // 4. Inicia la UI con Compose
        setContent {
            val navController = rememberNavController()
            AppNavGraph(
                navController = navController,
                lecturaViewModel = lecturaViewModel
            )
        }
    }
}
