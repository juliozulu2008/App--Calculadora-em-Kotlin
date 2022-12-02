package com.juliocdias.conversordemedidas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import kotlin.Double as Doublel

class ConversorComprimento : AppCompatActivity() {

    var unidades = arrayOf("Milimetro (mm)","Centimetro (cm)","Metro (m)","Quilometro (km)")
    var selecao = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversor_comprimento)

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
                    //milimetro
                    var texto = " Centimetro = "
                    texto +=  Double.parseDouble(valor)/ 10f
                    texto += "cm \n Metro = "
                    texto += Double.parseDouble(valor) / 1000f
                    texto += "m \n Quilometro = "
                    texto += Double.parseDouble(valor) / 1000000f
                    texto += "km"

                    txtResultado.text = texto

                }else if(selecao == 1){
                    //centimetro
                    var texto = " Milimetro = "
                    texto +=  Double.parseDouble(valor)* 10f
                    texto += "mm \n Metro = "
                    texto += Double.parseDouble(valor) / 100f
                    texto += "m \n Quilometro = "
                    texto += Double.parseDouble(valor) / 100000f
                    texto += "km"

                    txtResultado.text = texto

                }else if(selecao == 2){
                    //metro
                    var texto = " Milimetro = "
                    texto +=  Double.parseDouble(valor)* 1000f
                    texto += "mm \n Centimetro = "
                    texto += Double.parseDouble(valor) * 100f
                    texto += "cm \n Quilometro = "
                    texto += Double.parseDouble(valor) / 1000f
                    texto += "km"

                    txtResultado.text = texto

                }else if(selecao == 3){
                    //Quilometro

                    var texto = " Milimetro = "
                    texto +=  Double.parseDouble(valor)* 1000000f
                    texto += "mm \n Centimetro = "
                    texto += Double.parseDouble(valor) * 100000f
                    texto += "cm \n Metro = "
                    texto += Double.parseDouble(valor) * 1000f
                    texto += "m"

                    txtResultado.text = texto
                }
            } else {
                txtResultado.text = "Adicione um Valor para ser Convertido"
            }
        }


        //Ativar o "up navigation" na ActionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item?.itemId == android.R.id.home){
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}