package com.example.settingpaneldemo

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val INTERNET_SETTINGS_REQUEST = 1203
    val NFC_SETTINGS_REQUEST = 1204
    val VOLUME_SETTINGS_REQUEST = 1205

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_1.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                showInternetPanel()
            } else {
                Toast.makeText(
                    this,
                    "Your app version is too low,must be 10 or above",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        btn_2.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                showNFCSetting()
            } else {
                Toast.makeText(
                    this,
                    "Your app version is too low,must be 10 or above",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        btn_3.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                showVolumeSetting()
            } else {
                Toast.makeText(
                    this,
                    "Your app version is too low,must be 10 or above",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

    }

    @RequiresApi(Build.VERSION_CODES.Q)
    fun showInternetPanel() {
        startActivityForResult(
            Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY),
            INTERNET_SETTINGS_REQUEST
        )
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    fun showNFCSetting() {
        startActivityForResult(Intent(Settings.Panel.ACTION_NFC), NFC_SETTINGS_REQUEST)
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    fun showVolumeSetting() {
        startActivityForResult(Intent(Settings.Panel.ACTION_VOLUME), VOLUME_SETTINGS_REQUEST)
    }

}