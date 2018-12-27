package com.example.ricardo.testoauthfitbit

import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.pm.ApplicationInfo
import com.fitbit.authentication.*
import org.jetbrains.anko.toast


class FitBitAuthApplication : Application() {

    //This code is obtained when we register the application in dev.fitbit.com
    val CLIENT_SECRET = "35d96fbffdaa8ec6b9f1763eed840b42"

    //code obtained running the main method of SecureKeyGenerator.java (in lib FitBitAuth)
    val SECURE_KEY = "KmZCnMYxpGVey72+g7WAYXFfBHsR3L66Juz1FWu0gxc="


    /** setting the authentication config to connect to the FitBitAPI.
     * To do it, we need to pass our Client Credentials (generated in dev.fitbit.com),
     * the Scopes we want to access (e.g.: heartrate, nutrition, sleep...),
     * time to expire token, and which activity we'll return after it.
    **/
    private fun generateAuthenticationConfiguration(): AuthenticationConfiguration? { 
        val bundle = ApplicationInfo().metaData
        val clientId = bundle.getString("com.fitbit.sampleandroidoauth2.CLIENT_ID")
        val redirectUrl = bundle.getString("com.fitbit.sampleandroidoauth2.REDIRECT_URL")

        val clientCredentials = ClientCredentials(clientId, CLIENT_SECRET, redirectUrl)

        val config = AuthenticationConfigurationBuilder()
            .setClientCredentials(clientCredentials)
            .setEncryptionKey(SECURE_KEY)
            .addRequiredScopes(Scope.profile, Scope.settings)
            .build()
        return config
    }



    override fun onCreate() {
        super.onCreate()
        AuthenticationManager.configure(this, generateAuthenticationConfiguration())
    }

}