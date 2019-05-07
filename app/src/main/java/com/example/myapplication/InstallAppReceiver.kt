package com.example.myapplication

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.content.IntentFilter
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.support.v4.app.NotificationCompat
import android.support.v4.graphics.drawable.DrawableCompat
import com.google.gson.Gson
import android.opengl.ETC1.getHeight
import android.opengl.ETC1.getWidth
import android.graphics.Bitmap
import android.graphics.Canvas
import java.lang.Exception


class InstallAppReceiver : Service() {
    override fun onBind(intent: Intent?) = null


    val receiver = ABC()


    override fun onCreate() {
        super.onCreate()

        val intentFilter = IntentFilter(Intent.ACTION_PACKAGE_ADDED)
        intentFilter.addAction(Intent.ACTION_PACKAGE_CHANGED)
        intentFilter.addAction(Intent.ACTION_PACKAGE_REMOVED)
        intentFilter.addAction(Intent.ACTION_PACKAGE_REPLACED)
        intentFilter.addDataScheme("package")

        registerReceiver(receiver, intentFilter)


        println("--------------------------------------- start broadcast receiver ------- ")
    }


    override fun onDestroy() {
        unregisterReceiver(receiver)
        super.onDestroy()

    }

}


class ABC : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        println("--------------------------------------- Referrer is: ")
        println("--------------------------------------- Referrer is: ")
        println("--------------------------------------- Referrer is: ")
        println("--------------------------------------- Referrer is: ")
        println("--------------------------------------- Referrer is: ")
        println("--------------------------------------- Referrer is: ")
        println("--------------------------------------- Referrer is: ")
        println("--------------------------------------- Referrer is: ")
        println("--------------------------------------- Referrer is: ")
        println("--------------------------------------- Referrer is: ")
        println("--------------------------------------- Referrer is: ")
        println("--------------------------------------- Referrer is: ")
        println("--------------------------------------- Referrer is: ")
        println("--------------------------------------- Referrer is: ")
        println("--------------------------------------- Referrer is: ")

        try {
            createNotification(context, intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        println("--------------------------------------- Referrer is: ")
        println("--------------------------------------- Referrer is: ")
        println("--------------------------------------- Referrer is: ")
        println("--------------------------------------- Referrer is: ")
        println("--------------------------------------- Referrer is: ")
        println("--------------------------------------- Referrer is: ")
        println("--------------------------------------- Referrer is: ")
        println("--------------------------------------- Referrer is: ")
        println("--------------------------------------- Referrer is: ")
        println("--------------------------------------- Referrer is: ")
        println("--------------------------------------- Referrer is: ")
        println("--------------------------------------- Referrer is: ")
        println("--------------------------------------- Referrer is: ")
        println("--------------------------------------- Referrer is: ")
        println("--------------------------------------- Referrer is: ")
        println("--------------------------------------- Referrer is: ")
        println("--------------------------------------- Referrer is: ")
        println("--------------------------------------- Referrer is: ")
    }

    @Throws(Exception::class)
    private fun createNotification(context: Context, intent: Intent) {

        val data = intent.data.schemeSpecificPart
        val pm = context.packageManager
        val drawable = pm.getApplicationIcon(data)



        drawable?.let {

            val ai =  pm.getApplicationInfo(data, 0)

            val bitmap = Bitmap.createBitmap(drawable.intrinsicWidth, drawable.intrinsicHeight, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(bitmap)
            drawable.setBounds(0, 0, canvas.width, canvas.height)
            drawable.draw(canvas)

            val builder = NotificationCompat.Builder(context, BuildConfig.APPLICATION_ID).apply {
                setSmallIcon(R.mipmap.ic_launcher)
                setLargeIcon(bitmap)
                setContentTitle("App installed: ${pm.getApplicationLabel(ai)}")
                setContentText("Do you want to protect this app ?")
                setChannelId("987")
            }

            val notifyManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notifyManager.createNotificationChannel(
                    NotificationChannel(
                        "987",
                        context.getString(R.string.app_name),
                        NotificationManager.IMPORTANCE_DEFAULT
                    )
                )
            }
            notifyManager.cancel(1)
            notifyManager.notify(987, builder.build())
        }
    }
}