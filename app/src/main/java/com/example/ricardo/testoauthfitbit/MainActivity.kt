package com.example.ricardo.testoauthfitbit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.fitbit.authentication.AuthenticationManager
import org.jetbrains.anko.find

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val connectButton : Button = find(R.id.button_connect)

        connectButton.setOnClickListener { AuthenticationManager.login(this) }
    }



}
