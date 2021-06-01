package com.oseas.calculadoradejuros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var valor: EditText
    private lateinit var percent: EditText
    private lateinit var parcelas: EditText
    private lateinit var valorTotal: TextView
    private lateinit var texti: TextView
    private lateinit var calcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        valor = findViewById(R.id.valor)
        percent = findViewById(R.id.percent)
        parcelas = findViewById(R.id.parcelas)
        valorTotal = findViewById(R.id.valor_total)
        texti = findViewById(R.id.texti)
        calcular = findViewById(R.id.calcular)

        calcular.setOnClickListener {
            val a = valor.text.toString().toFloat()
            val b = percent.text.toString().toFloat()
            val valorMaisPercentual = a + (a * (b / 100))
            val numParcelas = parcelas.text.toString().toInt()

            valorTotal.text = valorMaisPercentual.toString()

            var txt = ""
            var valParcela = valorMaisPercentual / numParcelas

            val iterator = (1..numParcelas).iterator()
            iterator.forEach {
                txt += "$it Parcela -> R$ $valParcela \n"
            }

            texti.text = txt

        }
    }
}