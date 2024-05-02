package com.zaplor.bluetooth

import android.bluetooth.BluetoothAdapter
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.util.Log
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val state = intent?.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.STATE_OFF)
        val message = when (state) {
            BluetoothAdapter.STATE_ON -> "Bluetooth turned on"
            BluetoothAdapter.STATE_OFF -> "Bluetooth turned off"
            else -> "Bluetooth state changed"
        }
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        Log.d("TAG", message)
    }

    // functions definations...
    fun registerReceiver(context: Context){
        val filter = IntentFilter("BluetoothAdapter.ACTION_STATE_CHANGED")
        context.registerReceiver(this, filter)
    }
    fun unregisterReceiver(context: Context){
        context.unregisterReceiver(this)

    }
}