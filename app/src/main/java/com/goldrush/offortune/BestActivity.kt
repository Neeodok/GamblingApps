package com.goldrush.offortune

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.*
import android.webkit.*
import androidx.appcompat.app.AppCompatActivity
import com.goldrush.offortune.games.pulseBtnAnimation
import io.michaelrocks.paranoid.Obfuscate
import kotlinx.coroutines.*
import java.util.*

@Obfuscate
@SuppressLint("CustomSplashScreen")
class BestActivity : AppCompatActivity() {
    private val uiScope = CoroutineScope(Dispatchers.Main + Job())
    private val ioScope = CoroutineScope(Dispatchers.IO + Job())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // TODO начиначем анимацию загрузки, если таковая имеется



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
        }

        toMainActivity()
    }

    override fun onDestroy() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(true)
        }

        super.onDestroy()
    }


    private fun toMainActivity() {
        ioScope.launch {
            delay(3000) 
            uiScope.launch {
                if ( getSharedPreferences(sharedPrefsKey, MODE_PRIVATE).getBoolean(prefIsPhoneSavedKey, false)) {

                    startActivity(Intent(this@BestActivity, MenuActivity::class.java))

                } else startActivity(Intent(this@BestActivity, UserActivity::class.java))
                finish()
            }
        }
    }
}