package com.example.myfirstproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassification = findViewById<TextView>(R.id.textview_classification)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.0f)

        tvResult.text = result.toString()


        val classification = if (result < 18.5f){
            "UNDERWEIGHT"
        }else if (result in 18.5f..24.99f){
            "NORMAL"
        }else if (result in 25.0f..29.99f){
            "OVERWEIGHT"
        }else if (result in 30.0f..39.99f){
            "OBESITY"
        }else {
            "SEVERE OBESITY"
        }

        tvClassification.text = getString(R.string.message_classification, classification)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}