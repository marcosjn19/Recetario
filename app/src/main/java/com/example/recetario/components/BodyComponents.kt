package com.example.recetario.components

import android.graphics.drawable.Drawable
import android.icu.util.Measure
import android.icu.util.MeasureUnit
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun TitleBar(name : String) {
    Text(text = name, fontSize = 30.sp, color = Color.Black, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth())
}

@Composable
fun TarjetaReceta( nombreReceta: String, descripcionCorta : String, imagen : Int, navController: NavHostController) {
    Column(
        modifier = Modifier
            .shadow(elevation = 30.dp)
            .clip(RoundedCornerShape(10))
            .background(Color.White)
            .padding(20.dp)
    ) {
        Row () {
            TituloStyle1(titulo = nombreReceta)
        }

        Row ( modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp), verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center) {
            ImgPreviewReceta(imagen, nombreReceta)
            ParrafoStyle1(texto = descripcionCorta)
        }

        Row ( verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.End,
        modifier = Modifier.fillMaxWidth()) {
            BotonStyle1(titulo = "Ver más", onClick = {navController.navigate("detallesReceta/${nombreReceta}")})
        }
    }
}

@Composable
fun DescripcionReceta(descripcion: String) {
    Column(
        modifier = Modifier
            .shadow(elevation = 10.dp)
            .clip(RoundedCornerShape(10))
            .background(Color.White)
            .padding(20.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "Descripción",
            fontSize = 20.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Text(
            text = descripcion,
            fontSize = 16.sp,
            color = Color.Gray,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun PasosReceta(pasos: List<String>) {
    Column(
        modifier = Modifier
            .shadow(elevation = 10.dp)
            .clip(RoundedCornerShape(10))
            .background(Color.White)
            .padding(20.dp)
            .fillMaxWidth()

    ) {
        Text(
            text = "Pasos",
            fontSize = 20.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        pasos.forEachIndexed { index, paso ->
            Text(
                text = "${index + 1}. $paso",
                fontSize = 16.sp,
                color = Color.Gray,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(bottom = 5.dp)
            )
        }
    }
}

@Composable
fun ImagenReceta(imagen: Int, nombreReceta: String) {
    Box(
        modifier = Modifier
            .shadow(elevation = 10.dp)
            .clip(RoundedCornerShape(10))
            .background(Color.White)
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = imagen),
            contentDescription = nombreReceta,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
    }
}

@Composable
fun TituloStyle1 ( titulo : String ) {
    Text(
        text = titulo,
        fontWeight = FontWeight(weight = 800),
        fontSize = 25.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun ParrafoStyle1 ( texto : String ) {
    Text (
        text = texto,
        color = Color.Black,
        fontSize = 18.sp,
        modifier = Modifier.offset(y = 10.dp, x = 10.dp)
    )
}

@Composable
fun BotonStyle1 ( titulo : String, onClick: () -> Unit) {
    Button (
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color.hsl(hue = 285f, saturation = 1f, lightness = .25f, alpha = 1f)),
        modifier = Modifier
            .size(width = 150.dp, height = 50.dp)

    ) {
        Text(text = titulo, color = Color.White)
    }
}

@Composable
fun ImgPreviewReceta ( idR : Int , nombre : String) {
    Image(
        painter = painterResource(idR),
        contentDescription = "Imagen de " + nombre,
        modifier = Modifier.size(width = 150.dp, height = 150.dp).clip(CircleShape)
    )
}