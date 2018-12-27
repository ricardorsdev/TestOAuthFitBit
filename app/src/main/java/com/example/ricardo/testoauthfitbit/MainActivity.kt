package com.example.ricardo.testoauthfitbit

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.fitbit.authentication.AuthenticationHandler
import com.fitbit.authentication.AuthenticationManager
import com.fitbit.authentication.AuthenticationResult
import org.jetbrains.anko.find

class MainActivity : AppCompatActivity(), AuthenticationHandler {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val connectButton : Button = find(R.id.button_connect)
        connectButton.setOnClickListener { onConnectButtonClick() }
    }

    //Start new activity where will be showed tha FitBit Data
    fun onResultSuccess(){
        intent = Intent(this, UserDataActivity::class.java)
        startActivity(intent)
    }


    fun onConnectButtonClick(){
        AuthenticationManager.login(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(AuthenticationManager.onActivityResult(requestCode,resultCode,data,this)){
            //TODO
        }
    }

    override fun onAuthFinished(result: AuthenticationResult) {
        if(result.isSuccessful){
            onResultSuccess()
        } else {
            //TODO error treatment
        }
    }
}
