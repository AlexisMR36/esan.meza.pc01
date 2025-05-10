package com.example.esanmezapc01.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

data class Producto(val nombre: String, val precio: Double)

val productos = listOf(
    Producto("Laptop Dell", 3000.0),
    Producto("Smartphone Samsung", 2500.0),
    Producto("Auriculares Bluetooth", 300.0)
)

@Composable
fun Catalogo(navController: NavHostController) {
    Column(modifier = Modifier.padding(16.dp)) {
        LazyColumn {
            items(productos) { producto ->
                Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        Text(producto.nombre)
                        Text("Precio: S/.${producto.precio}")
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Total: S/.${productos.sumOf { it.precio }}")
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { navController.navigate("menu") }) {
            Text("Volver al Menú")
        }
    }
}
