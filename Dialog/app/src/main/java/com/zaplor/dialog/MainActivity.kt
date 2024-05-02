package com.zaplor.dialog

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonShowDialog: Button = findViewById(R.id.buttonShowDialog)

        buttonShowDialog.setOnClickListener {
            displayDialog()
        }
    }

    private fun displayDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Dialog Title")
        builder.setMessage("This is a dialog message.")
        builder.setPositiveButton("OK") { dialog, _ ->
            // Perform action on OK button click
            dialog.dismiss()
        }
        val dialog = builder.create()
        dialog.show()
    }
}
