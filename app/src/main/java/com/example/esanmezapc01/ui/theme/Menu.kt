package com.example.esanmezapc01.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Menu(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { navController.navigate("edadCanina") }) {
            Text("Calculadora Edad Canina")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { navController.navigate("conversorDivisas") }) {
            Text("Conversor Divisas")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { navController.navigate("catalogoProductos") }) {
            Text("Catálogo Productos")
        }
    }
}
