package com.example.esanmezapc01.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun EdadCanina(navController: NavHostController) {
    var edad by remember { mutableStateOf("") }
    var tamanio by remember { mutableStateOf("Pequeño") }
    var resultado by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }  // Estado para abrir/cerrar el dropdown

    Column(modifier = Modifier.padding(16.dp)) {
        // Campo para la edad del perro
        TextField(
            value = edad,
            onValueChange = { edad = it },
            label = { Text("Edad del perro (años humanos)") }
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Dropdown para seleccionar el tamaño del perro
        TextField(
            value = tamanio,
            onValueChange = {},
            label = { Text("Tamaño del perro") },
            readOnly = true,
            modifier = Modifier.fillMaxWidth().clickable { expanded = !expanded }
        )

        // Menu desplegable con las opciones
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false } // Cierra el dropdown si se hace clic fuera
        ) {
            listOf("Pequeño", "Mediano", "Grande").forEach { item ->
                DropdownMenuItem(
                    text = { Text(item) },
                    onClick = {
                    tamanio = item  // Actualiza el tamaño seleccionado
                    expanded = false // Cierra el dropdown
                })
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Botón para calcular la edad en años perro
        Button(onClick = {
            val edadInt = edad.toIntOrNull()
            resultado = if (edadInt != null) {
                when (tamanio) {
                    "Pequeño" -> "Edad en años perro: ${edadInt * 5}"
                    "Mediano" -> "Edad en años perro: ${edadInt * 6}"
                    "Grande" -> "Edad en años perro: ${edadInt * 7}"
                    else -> "Edad no válida"
                }
            } else {
                "Ingresa una edad válida"
            }
        }) {
            Text("Calcular")
        }

        Spacer(modifier = Modifier.height(8.dp))
        Text(resultado)

        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { navController.navigate("menu") }) {
            Text("Volver al Menú")
        }
    }
}



