package com.zaplor.button

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val myButton = findViewById<Button>(R.id.myButton)
        myButton.setOnClickListener {
            // Call your custom function here
            myCustomFunction()
        }
    }

    private fun myCustomFunction() {
        // Write your custom logic here
        // For example, display a toast message
        Toast.makeText(this, "Custom Function Called!", Toast.LENGTH_SHORT).show()
    }
}