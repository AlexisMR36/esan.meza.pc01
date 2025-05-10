package com.example.esanmezapc01.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp


@Composable
fun EdadCanina(navController: NavHostController) {
    var edad by remember { mutableStateOf("") }
    var tamanio by remember { mutableStateOf("Pequeño") }
    var resultado by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = edad, onValueChange = { edad = it }, label = { Text("Edad del perro (años humanos)") })
        Spacer(modifier = Modifier.height(8.dp))
        DropdownMenu(tamanio, onSelect = { tamanio = it })
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            val edadInt = edad.toIntOrNull()
            resultado = if (edadInt != null) {
                when (tamanio) {
                    "Pequeño" -> "Edad en años perro: ${edadInt * 5}"
                    "Mediano" -> "Edad en años perro: ${edadInt * 6}"
                    else -> "Edad en años perro: ${edadInt * 7}"
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

@Composable
fun DropdownMenu(selected: String, onSelect: (String) -> Unit) {
    val opciones = listOf("Pequeño", "Mediano", "Grande")
    var expanded by remember { mutableStateOf(false) }

    Box {
        TextField(
            value = selected,
            onValueChange = {},
            label = { Text("Tamaño del perro") },
            readOnly = true,
            modifier = Modifier.fillMaxWidth().clickable { expanded = true }
        )
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            opciones.forEach {
                DropdownMenuItem(onClick = {
                    onSelect(it)
                    expanded = false
                }) {
                    Text(it)
                }
            }
        }
    }
}
