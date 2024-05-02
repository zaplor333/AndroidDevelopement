package com.zaplor.alarmmanager

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var alarmHelper: AlarmHelper
    private lateinit var timeTextView: TextView
    private lateinit var editText: EditText
    private lateinit var setAlarmButton: Button
    private lateinit var cancelAlarmButton: Button

    private var selectedTimeInMillis: Long = 0L


    //loop mehtod 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // assign values...
        alarmHelper = AlarmHelper()
        timeTextView = findViewById(R.id.timeTextView)
        editText = findViewById(R.id.editText)
        setAlarmButton = findViewById(R.id.setAlarmButton)
        cancelAlarmButton = findViewById(R.id.cancelAlarmButton)


        // click listners...
        setAlarmButton.setOnClickListener{
            set10SecondAlarm()
        }

        cancelAlarmButton.setOnClickListener {
            cancelAlarm()
        }



//        // Set initial time display to "Not Set"
//        timeTextView.text = getString(R.string.not_set)
//
//        setAlarmButton.setOnClickListener {
//            val calendar = Calendar.getInstance()
//            val timePickerDialog = TimePickerDialog(
//                this,
//                { view, hourOfDay, minute ->
//                    // Set the selected time for the alarm
//                    val selectedTime = Calendar.getInstance()
//                    selectedTime.set(Calendar.HOUR_OF_DAY, hourOfDay)
//                    selectedTime.set(Calendar.MINUTE, minute)
//                    selectedTimeInMillis = selectedTime.timeInMillis
//
//                    // Check if selected time is in the past (avoid past alarms)
//                    if (selectedTimeInMillis < System.currentTimeMillis()) {
//                        Toast.makeText(this, "Please select a future time", Toast.LENGTH_SHORT).show()
//                    } else {
//                        val timeString = android.text.format.DateFormat.getTimeFormat(this).format(selectedTime.timeInMillis)
//                        timeTextView.text = timeString
//                    }
//                },
//                calendar.get(Calendar.HOUR_OF_DAY),
//                calendar.get(Calendar.MINUTE),
//                true // Use 24-hour format
//            )
//            timePickerDialog.show()
//        }


    }

    // Function to set a 10-second alarm (optional, call it from a separate button)
    private fun set10SecondAlarm() {
        val enteredDurationString = editText.text.toString().trim()

        if (enteredDurationString.isNotEmpty()){
            val durationInSeconds = enteredDurationString.toIntOrNull()
            if (durationInSeconds != null && durationInSeconds > 0){
                val currentTime = System.currentTimeMillis()
                val SecondsInMillis = durationInSeconds * 1000 // Convert seconds to milliseconds

                val intent = Intent(this, MyReceiver::class.java).apply {
                    action = "com.zaplor.alarmmanager.ALARM_ACTION"
                }
                alarmHelper.setAlarm(this, currentTime + SecondsInMillis, intent)

                val timeString = "Alarm set in $durationInSeconds seconds"
                timeTextView.text = timeString
                selectedTimeInMillis = currentTime + SecondsInMillis

            }

        }

    }
    private fun cancelAlarm(){
        if (selectedTimeInMillis > 0) {
            val intent = Intent(this, MyReceiver::class.java).apply {
                action = "com.zaplor.alarmmanager.ALARM_ACTION"
            }
            alarmHelper.cancelAlarm(this, intent)
            timeTextView.text = getString(R.string.not_set)
            selectedTimeInMillis = 0L
            Toast.makeText(this, "Alarm canceled", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "No alarm set to cancel", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        const val NOT_SET = "Not Set"
    }
}