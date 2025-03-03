package com.example.recetario.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recetario.components.DescripcionReceta
import com.example.recetario.components.ImagenReceta
import com.example.recetario.components.PasosReceta
import com.example.recetario.components.TitleBar
import com.example.recetario.R // Asegúrate de tener los recursos de imagen

// Data class para contener todos los detalles de la receta
data class RecipeDetails(
    val descripcion: String,
    val pasos: List<String>,
    val imagenId: Int,
    val ingredientes: List<String>
)

@Composable
fun RecipeView(nombreReceta: String) {
    val detalles = obtenerDetallesReceta(nombreReceta)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp).verticalScroll(rememberScrollState()), // Habilita el scroll manual,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp)
            .shadow(30.dp)) {
            TitleBar(name = nombreReceta)
        }

        Spacer(Modifier.size(30.dp))

        ImagenReceta(
            imagen = detalles.imagenId,
            nombreReceta = nombreReceta
        )

        Spacer(Modifier.size(30.dp))

        DescripcionReceta(detalles.descripcion)
        Spacer(Modifier.size(30.dp))

        IngredientesReceta(detalles.ingredientes)
        Spacer(Modifier.size(30.dp))

        PasosReceta(detalles.pasos)
        Spacer(Modifier.size(30.dp))
    }
}

// Componente para mostrar los ingredientes
@Composable
fun IngredientesReceta(ingredientes: List<String>) {
    Column(
        modifier = Modifier
            .shadow(elevation = 10.dp)
            .clip(RoundedCornerShape(10))
            .background(Color.White)
            .padding(20.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "Ingredientes",
            fontSize = 20.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Column {
            ingredientes.forEach { ingrediente ->
                Text(
                    text = "• $ingrediente",
                    fontSize = 16.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(vertical = 3.dp)
                )
            }
        }
    }
}

fun obtenerDetallesReceta(nombreReceta: String): RecipeDetails {
    return when (nombreReceta) {
        "Pastel" -> RecipeDetails(
            descripcion = "Un delicioso pastel de chocolate.",
            pasos = listOf(
                "Precalienta el horno a 180°C.",
                "Mezcla los ingredientes secos.",
                "Agrega los ingredientes húmedos y mezcla bien.",
                "Hornea por 30 minutos.",
                "Deja enfriar antes de servir."
            ),
            imagenId = R.drawable.pastel, // Reemplaza con tu recurso real
            ingredientes = listOf(
                "200g de harina",
                "150g de chocolate",
                "3 huevos",
                "200ml de leche",
                "100g de mantequilla"
            )
        )

        "Pizza" -> RecipeDetails(
            descripcion = "Una pizza casera con tus ingredientes favoritos.",
            pasos = listOf(
                "Prepara la masa y estírala en una bandeja.",
                "Agrega la salsa de tomate y los ingredientes.",
                "Hornea a 220°C por 15-20 minutos.",
                "Retira del horno y sirve caliente."
            ),
            imagenId = R.drawable.pizza,
            ingredientes = listOf(
                "Masa para pizza",
                "Salsa de tomate",
                "Queso mozzarella",
                "Ingredientes adicionales al gusto"
            )
        )

        "Carlota" -> RecipeDetails(
            descripcion = "Un postre frío y refrescante hecho con galletas y crema.",
            pasos = listOf(
                "Coloca una capa de galletas en un molde.",
                "Cubre con una capa de crema.",
                "Repite las capas hasta llenar el molde.",
                "Refrigera por al menos 4 horas antes de servir."
            ),
            imagenId = R.drawable.carlota,
            ingredientes = listOf(
                "Paquete de galletas María",
                "500ml de crema para batir",
                "1 lata de leche condensada",
                "Jugo de limón al gusto"
            )
        )

        "Enchiladas" -> RecipeDetails(
            descripcion = "Enchiladas de pollo con salsa de tomate.",
            pasos = listOf(
                "Cocina el pollo y desmenúzalo.",
                "Rellena las tortillas con el pollo y enrolla.",
                "Cubre con salsa de tomate y queso.",
                "Hornea a 180°C por 20 minutos.",
                "Sirve caliente con crema y lechuga."
            ),
            imagenId = R.drawable.enchiladas,
            ingredientes = listOf(
                "Pechuga de pollo",
                "Tortillas de maíz",
                "Salsa de tomate",
                "Queso fresco",
                "Crema ácida"
            )
        )

        else -> RecipeDetails(
            descripcion = "Receta no encontrada.",
            pasos = listOf("No hay pasos disponibles para esta receta."),
            imagenId = R.drawable.ic_launcher_background, // Imagen por defecto
            ingredientes = emptyList()
        )
    }
}