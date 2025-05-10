package com.example.esanmezapc01.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun ConversorDivisas(navController: NavHostController) {
    var monto by remember { mutableStateOf("") }
    var tipoCambio by remember { mutableStateOf("USD a PEN") }
    var resultado by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = monto, onValueChange = { monto = it }, label = { Text("Monto") })
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            RadioButton(selected = tipoCambio == "USD a PEN", onClick = { tipoCambio = "USD a PEN" })
            Text("USD a PEN")
            Spacer(modifier = Modifier.width(16.dp))
            RadioButton(selected = tipoCambio == "PEN a USD", onClick = { tipoCambio = "PEN a USD" })
            Text("PEN a USD")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            val montoDouble = monto.toDoubleOrNull()
            resultado = if (montoDouble != null) {
                if (tipoCambio == "USD a PEN") "Resultado: S/.${montoDouble * 3.80}"
                else "Resultado: \$${montoDouble / 3.80}"
            } else {
                "Ingresa un monto válido"
            }
        }) {
            Text("Convertir")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(resultado)
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { navController.navigate("menu") }) {
            Text("Volver al Menú")
        }
    }
}
