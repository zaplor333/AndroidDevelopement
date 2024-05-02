package com.zaplor.battery

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.widget.Toast
import android.widget.TextView


class MyReceiver : BroadcastReceiver() {

    private var batteryLevel = 0

    override fun onReceive(context: Context, intent: Intent){
        val level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
        val scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
        batteryLevel = (level * 100 / scale).toInt()

        val textView = (context as MainActivity).findViewById<TextView>(R.id.textView)
        textView.text =  "Battery Level :  " + batteryLevel.toString() + "%"//context.getString(R.string.battery_level)



//        // Optional: Display toast message for low battery
//        if (batteryLevel < 15) {
//            Toast.makeText(context, "Low battery! Please charge your device", Toast.LENGTH_SHORT).show()
//        }
    }

    // function definitions...
    fun registerReceiver(context: Context) {
        val filter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        context.registerReceiver(this, filter)
    }

    fun unregisterReceiver(context: Context) {
        context.unregisterReceiver(this)
    }
}