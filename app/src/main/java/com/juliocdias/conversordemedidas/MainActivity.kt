package com.juliocdias.conversordemedidas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Carregando Componentes
        val btnComprimento = findViewById<ImageButton>(R.id.btnComplimento)
        btnComprimento.setOnClickListener{
            val intent = Intent(this, ConversorComprimento::class.java)
            startActivity(intent)
        }
        val btnDados = findViewById<ImageButton>(R.id.btnDados)
        btnDados.setOnClickListener{
            val intent = Intent(this, ConversorDados::class.java)
            startActivity(intent)
        }
        val btnTemperatura = findViewById<ImageButton>(R.id.btnTemperatura)
        btnTemperatura.setOnClickListener{
            val intent = Intent(this, ConversorTemperatura::class.java)
            startActivity(intent)
        }
        val btnPesoEMassa = findViewById<ImageButton>(R.id.btnPeso)
        btnPesoEMassa.setOnClickListener{
            val intent = Intent(this, ConversorPesoEMassa::class.java)
            startActivity(intent)
        }

    }
}