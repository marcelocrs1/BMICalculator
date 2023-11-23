package com.example.myfirstproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnResult: Button = findViewById(R.id.btnResult)
        val edtHeight: EditText =  findViewById(R.id.edtHeight)
        val edtWeight: EditText =  findViewById(R.id.edtWeight)

        btnResult.setOnClickListener{

            val heightStr = edtHeight.text.toString()
            val weightStr = edtWeight.text.toString()

            if (heightStr.isNotEmpty() && weightStr.isNotEmpty()){


                val height : Float = heightStr.toFloat()
                val weight : Float = weightStr.toFloat()

                val userHeight: Float = height * height
                val userWeight: Float = weight
                val result = userWeight / userHeight

                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", result)
                    }
                startActivity(intent)

            }else {
                Toast.makeText(this, "Fill out the fields", Toast.LENGTH_LONG).show()
            }
        }
    }
}