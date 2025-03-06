package com.example.recetario.views

import android.annotation.SuppressLint
import android.app.Notification
import android.app.Notification.Action
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.fondo_cocina),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .blur(2.dp),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),
                elevation = CardDefaults.cardElevation(8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center // Centrar contenido en el Box
                ) {
                    Text(
                        text = "Recetario",
                        fontSize = 30.sp,
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            }

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
}