package com.zaplor.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()

        val editTextName: EditText = findViewById(R.id.editTextName)
        val buttonSave: Button = findViewById(R.id.buttonSave)
        val buttonRetrieve: Button = findViewById(R.id.buttonRetrieve)

        buttonSave.setOnClickListener {
            val name = editTextName.text.toString()
            editor.putString("Name", name)
            editor.apply()
            Toast.makeText(this, "Name saved successfully", Toast.LENGTH_SHORT).show()
        }

        buttonRetrieve.setOnClickListener {
            val savedName = sharedPreferences.getString("Name", "")
            Toast.makeText(this, "Saved Name: $savedName", Toast.LENGTH_SHORT).show()
        }
    }
}
