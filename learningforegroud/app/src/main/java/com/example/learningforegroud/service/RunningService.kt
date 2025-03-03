package com.example.learningforegroud.service


import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.example.learningforegroud.MainActivity
import com.example.learningforegroud.R

class RunningService : Service() {



    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            Actions.START.toString() -> start()
            Actions.STOP.toString() -> stopSelf()

        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun start() {

        // Variable intent and penddingIntent used purpose for can click foreground notif to open activity
        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        val pendingIntent =
            PendingIntent.getActivity(
                this,
                0,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )

        val notification = NotificationCompat.Builder(this, "running_channel")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("This Foreground")
            .setContentText("Learning launch Foreground Notification")
            .setContentIntent(pendingIntent)
            .build()
        startForeground(1, notification)
    }

    enum class Actions {
        START, STOP
    }
}