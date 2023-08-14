package com.example.pagos

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Regular : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regular)

        val btnVolver =  findViewById<Button>(R.id.btnVolver)
        btnVolver.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity( intent )
        }
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        btnCalcular.setOnClickListener {
            val resultado = findViewById<TextView>(R.id.Salario)
            val sueldoBruto = findViewById<EditText>(R.id.sueldo)

            val a = sueldoBruto.text.toString().toDoubleOrNull() ?: 0.0
            val sueldoNeto = EmpleadoRegular(a).calcularLiquido()
            resultado.text = "Sueldo Neto: $sueldoNeto"
        }
    }
}