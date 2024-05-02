package com.zaplor.sms

import android.app.AlertDialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.telephony.SmsMessage
import android.util.Log
import android.widget.Toast

class MyReceiver : BroadcastReceiver(){
    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action

        if (action == Telephony.Sms.Intents.SMS_RECEIVED_ACTION) {
            val pdus = intent.extras?.get("pdus") as Array<*>
            for (pdu in pdus) {
                val message = SmsMessage.createFromPdu(pdu as ByteArray)
                val senderNumber = message.displayOriginatingAddress
                val messageBody = message.displayMessageBody

                // Process the received SMS
                Log.d("SmsReceiver", "SMS from: $senderNumber, Message: $messageBody")
                // You can display a notification, save the message, etc.
                Toast.makeText(context, "SMS from: $senderNumber, Message: $messageBody", Toast.LENGTH_LONG).show()
            }
        }
    }
}