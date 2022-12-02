package com.juliocdias.conversordemedidas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import  kotlin.Double as Doublel
import java.util.*

class ConversorTemperatura : AppCompatActivity() {

    var unidades = arrayOf("Celsius (ºC)", "Kelvin (k)", "Fahrenheith (ºF)")
    var selecao = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversor_temperatura)
        //Carregar os Componentes
        val spinner = findViewById<Spinner>(R.id.select)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)
        val txtValor = findViewById<EditText>(R.id.txtValor)
        val btnCalcular = findViewById<Button>(R.id.btnConverter)
        // Cria Array Adapter
        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,unidades)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                selecao = p2
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }

        btnCalcular.setOnClickListener {
            val valor = txtValor.text.toString()
            if(valor != ""){
                if(selecao == 0){
                    var texto = " Kelvin = "
                    texto +=  formataValor(Double.parseDouble(valor) + 273.15)
                    texto += "K \n Fahrenheit = "
                    texto += formataValor((Double.parseDouble(valor) * 9/5)+ 32f)
                    texto += "°F"
                    txtResultado.text = texto

                }else if(selecao == 1){
                    var texto = " Celsius = "
                    texto +=  formataValor(Double.parseDouble(valor) - 273.15)
                    texto += "°C \n Fahrenheit = "
                    texto += formataValor((Double.parseDouble(valor) - 273.15)* 9/5 + 32f)
                    texto += "°F \n"

                    txtResultado.text = texto

                }else if(selecao == 2){
                    var texto = " Celsius = "
                    texto +=  formataValor((Double.parseDouble(valor) - 32) * 5/9 )
                    texto += "°C \n Kelvin = "
                    texto += formataValor((Double.parseDouble(valor) - 32) * 5/9 + 273.15)
                    texto += "K"


                    txtResultado.text = texto

                }
            }else{
                txtResultado.text = "Adicione um valor para ser Convertido!"
            }
        }

        //Ativar o "up navigation" na ActionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun formataValor(valor: kotlin.Double): Any? {
        return String.format(Locale.FRANCE,"%.2f",valor)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item?.itemId == android.R.id.home){
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}