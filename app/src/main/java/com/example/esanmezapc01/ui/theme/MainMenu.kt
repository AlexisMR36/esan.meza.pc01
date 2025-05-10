package com.example.esanmezapc01.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MainMenu(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Menú Principal", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("edadCanina") }) {
            Text("Calculadora de Edad Canina")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { navController.navigate("conversorDivisas") }) {
            Text("Conversor de Divisas")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { navController.navigate("catalogoProductos") }) {
            Text("Catálogo de Productos Tecnológicos")
        }
    }
}
