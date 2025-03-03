package com.example.recetario.views

import android.annotation.SuppressLint
import android.app.Notification
import android.app.Notification.Action
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.recetario.R
import com.example.recetario.components.TarjetaReceta
import com.example.recetario.navigation.NavManager

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavHostController) {
    Scaffold(
    ) {
        ContentView( navController)
    }
}

@Composable
private fun ContentView(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.hsl(hue = 280f, saturation = 0.7f, lightness = 0.8f, 1f))
            .padding(30.dp)
            .verticalScroll(rememberScrollState()), // Habilita el scroll manual
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TarjetaReceta(
            nombreReceta = "Pastel",
            descripcionCorta = "Un delicioso pastel dulce y esponjoso.",
            R.drawable.pastel,
            navController = navController
        )
        Spacer(Modifier.size(20.dp))

        TarjetaReceta(
            nombreReceta = "Pizza",
            descripcionCorta = "Masa crujiente con queso derretido y tus ingredientes favoritos.",
            R.drawable.pizza,
            navController = navController
        )
        Spacer(Modifier.size(20.dp))

        TarjetaReceta(
            nombreReceta = "Carlota",
            descripcionCorta = "Postre frío con galletas y crema de limón.",
            R.drawable.carlota,
            navController = navController
        )
        Spacer(Modifier.size(20.dp))

        TarjetaReceta(
            nombreReceta = "Enchiladas",
            descripcionCorta = "Tortillas rellenas bañadas en salsa de chile.",
            R.drawable.enchiladas,
            navController = navController
        )
    }
}