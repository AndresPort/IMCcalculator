package com.example.imccalculator
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    fun calculateImc(height:Int, weight:Int): Double{
        val mtHeight:Double= height.toDouble()/100
        val imc: Double= weight/(mtHeight* mtHeight)
        return(imc)
    }

    fun calculateImcClasification(imc:Double):String{
        val clasification:String

        if(imc < 18.5){
            clasification="Peso inferior al normal"
        }
        else if (imc>=18.5 && imc<25){
            clasification="Peso normal"
        }
        else if (imc>=25 && imc<30){
            clasification="sobre peso"
        }
        else if (imc>=30 && imc<35){
            clasification="Obesidad I"
        }
        else if (imc>=35 && imc<40){
            clasification="Obesidad II"
        }
        else {
            clasification="Obesidad III"
        }
        return (clasification)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var tvHeight: Int= intent.getIntExtra("HEIGHT",0)
        var tvWeight: Int= intent.getIntExtra(  "WEIGHT",0)
        var tvResult= findViewById<TextView>(R.id.tvResult)

        var tvClasificationResult= findViewById<TextView>(R.id.tvClasificationResult)
        
        var imc:Double = calculateImc(tvHeight,tvWeight)

        tvClasificationResult.text = "${calculateImcClasification(imc)}"

        tvResult.text= "$imc"
        var rvClasificationResult= findViewById<TextView>(R.id.tvClasificationResult).text.toString()

    }
}