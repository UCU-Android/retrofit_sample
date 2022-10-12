package com.bfrachia.myfirstinternetapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bfrachia.myfirstinternetapp.extensions.md5
import com.bfrachia.myfirstinternetapp.extensions.toHex
import java.util.Date
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onResume() {
        super.onResume()

        thread {
            val timeStamp = Date().time.toString()
            val characters = MarvelClient.service
                .listCharacters(
                    apiKey = BuildConfig.PUBLIC_KEY,
                    orderBy = "-modified",
                    ts = timeStamp,
                    hash = "$timeStamp${BuildConfig.PRIVATE_KEY}${BuildConfig.PUBLIC_KEY}".md5().toHex()
                )

            val response = characters.execute().body()

            if (response != null) {
                Log.v("CHARACTERS", "Response = $response")
            }
        }
    }
}