package com.zaplor.silentmode

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.media.AudioManager
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val audioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        val ringerMode = audioManager.ringerMode

        val message = when (ringerMode) {
            AudioManager.RINGER_MODE_SILENT -> "Silent mode enabled"
            AudioManager.RINGER_MODE_NORMAL -> "Silent mode disabled"
            else -> "Ringer mode changed"
        }
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()

        // You can optionally perform other actions based on ringer mode here
        // For example, update UI elements in an Activity
    }

    fun registerReceiver(context: Context) {
        val filter = IntentFilter(AudioManager.RINGER_MODE_CHANGED_ACTION)
        context.registerReceiver(this, filter)
    }

    fun unregisterReceiver(context: Context) {
        context.unregisterReceiver(this)
    }
}