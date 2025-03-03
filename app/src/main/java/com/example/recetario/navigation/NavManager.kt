package com.example.recetario.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.recetario.views.HomeView
import com.example.recetario.views.RecipeView

@Composable
fun NavManager () {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home") {
        composable( route = "Home" ){
            HomeView( navController)
        }
        composable(route = "detallesReceta/{nombreReceta}") { backStackEntry ->
            val nombre = backStackEntry.arguments?.getString("nombreReceta") ?: ""
            RecipeView(nombre) // Pantalla de detalles de la receta
        }
    }
}