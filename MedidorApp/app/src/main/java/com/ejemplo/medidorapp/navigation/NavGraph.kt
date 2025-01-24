package com.ejemplo.medidorapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ejemplo.medidorapp.ui.FormularioScreen
import com.ejemplo.medidorapp.ui.ListadoScreen
import com.ejemplo.medidorapp.ui.LecturaViewModel

@Composable
fun AppNavGraph(
    navController: NavHostController,
    lecturaViewModel: LecturaViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Destinos.LISTADO.ruta
    ) {
        composable(Destinos.LISTADO.ruta) {
            // Pantalla de Listado
            ListadoScreen(
                viewModel = lecturaViewModel,
                onFabClick = {
                    navController.navigate(Destinos.FORMULARIO.ruta)
                }
            )
        }
        composable(Destinos.FORMULARIO.ruta) {
            // Pantalla de Formulario
            FormularioScreen(
                viewModel = lecturaViewModel,
                onRegistroExitoso = {
                    // Vuelve atrás
                    navController.popBackStack()
                }
            )
        }
    }
}
