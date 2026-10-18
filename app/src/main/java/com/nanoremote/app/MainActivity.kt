package com.nanoremote.app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var tvDeviceId: TextView
    private lateinit var tvCode: TextView
    private lateinit var tvStatus: TextView
    private lateinit var etIp: EditText
    private lateinit var etCode: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val deviceId = "NR-" + Random.nextInt(1000, 9999) + "-" + Random.nextInt(1000, 9999)
        val secretCode = Random.nextInt(100000, 999999).toString()

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(48, 48, 48, 48)
        }

        val title = TextView(this).apply {
            text = "Nano Remote"
            textSize = 24f
        }
        tvDeviceId = TextView(this).apply {
            text = "Ваш ID: $deviceId"
            textSize = 18f
        }
        tvCode = TextView(this).apply {
            text = "Код: $secretCode"
            textSize = 18f
        }
        tvStatus = TextView(this).apply {
            text = "Статус: отключено"
            textSize = 16f
        }
        etIp = EditText(this).apply {
            hint = "IP компьютера (192.168.1.x)"
        }
        etCode = EditText(this).apply {
            hint = "Секретный код ПК"
        }
        val btnConnect = Button(this).apply {
            text = "Подключиться"
            setOnClickListener {
                val ip = etIp.text.toString()
                tvStatus.text = "Статус: подключение к $ip..."
                Toast.makeText(this@MainActivity, "Подключение к $ip", Toast.LENGTH_SHORT).show()
            }
        }
        val btnDisconnect = Button(this).apply {
            text = "Отключить"
            setOnClickListener {
                tvStatus.text = "Статус: отключено"
            }
        }

        layout.addView(title)
        layout.addView(tvDeviceId)
        layout.addView(tvCode)
        layout.addView(tvStatus)
        layout.addView(etIp)
        layout.addView(etCode)
        layout.addView(btnConnect)
        layout.addView(btnDisconnect)

        setContentView(layout)
    }
}
