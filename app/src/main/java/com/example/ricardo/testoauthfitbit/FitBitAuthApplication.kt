package com.example.ricardo.testoauthfitbit

import android.app.Application
import android.content.pm.ApplicationInfo
import com.fitbit.authentication.*
import org.jetbrains.anko.toast


class FitBitAuthApplication : Application() {

    val CLIENT_SECRET = "35d96fbffdaa8ec6b9f1763eed840b42"
    val SECURE_KEY = "KmZCnMYxpGVey72+g7WAYXFfBHsR3L66Juz1FWu0gxc="

    override fun onCreate() {
        super.onCreate()

        val bundle = ApplicationInfo().metaData
        val clientId = bundle.getString("com.fitbit.sampleandroidoauth2.CLIENT_ID")
        val redirectUrl = bundle.getString("com.fitbit.sampleandroidoauth2.REDIRECT_URL")

        val clientCredentials = ClientCredentials(clientId,CLIENT_SECRET,redirectUrl)

        val config = AuthenticationConfigurationBuilder()
            .setClientCredentials(clientCredentials)
            .setEncryptionKey(SECURE_KEY)
            .addRequiredScopes(Scope.profile, Scope.settings)
            .build()

        AuthenticationManager.configure(this, config)
    }
}