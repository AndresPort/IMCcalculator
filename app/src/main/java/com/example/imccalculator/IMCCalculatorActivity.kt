package com.example.imccalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class IMCCalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imccalculator)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var btnCalculate =findViewById<Button>(R.id.btnCalculate)

        btnCalculate.setOnClickListener{
            var etHeight = findViewById<EditText>(R.id.etFirstQuest).text.toString().toIntOrNull()?:0
            var etWeight= findViewById<EditText>(R.id.etSecondQuest).text.toString().toIntOrNull() ?:0

            if (etHeight != 0 && etWeight != 0){
                val intent = Intent(this, ResultActivity::class.java )
                intent.putExtra("HEIGHT", etHeight)
                intent.putExtra("WEIGHT", etWeight)
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"Ninguno de los valores ingresados puede se 0", Toast.LENGTH_SHORT).show()
            }

        }


    }
}