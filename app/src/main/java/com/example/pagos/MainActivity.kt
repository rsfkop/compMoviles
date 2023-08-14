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
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaInicio()
        }
    }
}


abstract class Empleado(val sueldoBruto: Double) {
    abstract fun calcularLiquido(): Double
}

class EmpleadoHonorarios(sueldoBruto: Double) : Empleado(sueldoBruto) {
    override fun calcularLiquido(): Double {
        return sueldoBruto * 0.87
    }
}

class EmpleadoRegular(sueldoBruto: Double) : Empleado(sueldoBruto) {
    override fun calcularLiquido(): Double {

        return sueldoBruto * 0.80
    }
}

@Preview
@Composable
fun PantallaInicio() {
    val contexto = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { val intent = Intent(contexto,Honorarios::class.java)
            contexto.startActivity( intent )

        }){
            Text(text = "Pagos a Honorarios")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { val intent = Intent(contexto,Regular::class.java)
            contexto.startActivity( intent )

        }){
            Text(text = "Pagos a Contratados")
        }
    }
}