package com.example.pagos

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class Honorarios : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaCalculoHonorarios()

        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PantallaCalculoHonorarios() {
    var sueldoBruto by remember { mutableStateOf("0.0") }
    var resultado by remember { mutableStateOf("") }
    val contexto = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            val intent = Intent(contexto, MainActivity::class.java)
            contexto.startActivity(intent)
        }) {
            Text(text = "<- Volver")
        }
        TextField(
            value = sueldoBruto,
            onValueChange = { sueldoBruto = it },
            label = { Text("Sueldo Bruto") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = {
                val a = sueldoBruto.toDoubleOrNull() ?: 0.0
                val sueldoNeto = EmpleadoHonorarios(a).calcularLiquido()
                resultado = "Sueldo Neto: $sueldoNeto"
            }
        ) {
            Text("Calcular Sueldo Neto")
        }

        Spacer(modifier = Modifier.height(40.dp))

        Text(text = resultado) // Agregar esta línea para mostrar el resultado en pantalla

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                sueldoBruto = "0.0"
                resultado = "" // Limpiar también el resultado al limpiar el sueldo
            }
        ) {
            Text("Limpiar")
        }
    }
}
