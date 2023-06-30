package com.itis.summerpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import java.lang.Exception
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultView = findViewById<TextView>(R.id.resultView)

        val button = findViewById<AppCompatButton>(R.id.calculateButton)
        button.setOnClickListener{
            val name = findViewById<EditText>(R.id.nameField).text.toString()
            val age = findViewById<EditText>(R.id.ageField).text.toString().toInt()
            val height = findViewById<EditText>(R.id.tallField).text.toString().toInt()
            val weight = findViewById<EditText>(R.id.weightField).text.toString().toDouble()
            if(checkData(name, age, height, weight)) {
                val result = getResultBySecretFormula(name, age, height, weight).toString()
                resultView.text = "Ответ: $result"
            } else
                resultView.text = "Некорректные данные"
        }
    }

    private fun checkData(name: String, age: Int, height: Int, weight: Double) : Boolean {
        if(name.isEmpty() || name.length > 50 )
            return false
        if(age < 1 || age > 149)
            return false
        if(height < 1 || height > 249)
            return false
        if(weight <= 0 || weight >= 250)
            return false
        return true
    }

    private fun getResultBySecretFormula(name: String, age: Int, height: Int, weight: Double) : Int {
        val p = 3211.0
        val result = name.hashCode() * Math.pow(p, 3.0) + age.hashCode() * Math.pow(p, 2.0) + height * p + weight
        return result.roundToInt()
    }
}