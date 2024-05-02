package com.zaplor.charging

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.util.Log
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val isCharging = when (intent.action) {
            Intent.ACTION_POWER_CONNECTED -> true
            Intent.ACTION_POWER_DISCONNECTED -> false
            else -> false
        }

        val message = if (isCharging) "Charging started" else "Charging stopped"
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()


        // You can perform additional actions based on charging state here
        // For example, update UI elements in an Activity
    }
    fun registerReceiver(context: Context) {
        val filter = IntentFilter().apply {
            addAction(Intent.ACTION_POWER_CONNECTED)
            addAction(Intent.ACTION_POWER_DISCONNECTED)
        }
        context.registerReceiver(this, filter)
    }

    fun unregisterReceiver(context: Context) {
        context.unregisterReceiver(this)
    }

}