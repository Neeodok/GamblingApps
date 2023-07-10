package com.goldrush.offortune

import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import com.goldrush.offortune.databinding.ActivityMainBinding
import io.michaelrocks.paranoid.Obfuscate

@Obfuscate
class UserActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val etPhone by lazy { binding.etPhone }
    private val btnStartMenu by lazy { binding.btnStart }
    private val btnAnonMode by lazy { binding.btnAnonMode }

    private val sharedPrefs: SharedPreferences by lazy { getSharedPreferences(sharedPrefsKey, MODE_PRIVATE )}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        btnStartMenu.setOnClickListener {
            MediaPlayer.create(this,R.raw.sound_btn_start).start()
            if (isPhoneNumber(etPhone.text.toString())) {

                savePhoneNumber(etPhone.toString())

                startActivity(
                    Intent(
                        this, MenuActivity::class.java
                    )
                        .addFlags(
                            Intent.FLAG_ACTIVITY_NEW_TASK
                                    or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        )
                )
                overridePendingTransition(R.anim.diagonaltranslate,R.anim.alpha)
            } else Toast.makeText(this, "incorrect input", Toast.LENGTH_SHORT).show()
        }
        btnAnonMode.setOnClickListener {
            startActivity(Intent(this@UserActivity,MenuActivity::class.java))
            overridePendingTransition(R.anim.diagonaltranslate,R.anim.alpha)
        }
    }

    private fun savePhoneNumber(phoneStr: String) {

        sharedPrefs.edit().putString(prefPhoneNumberKey, phoneStr).apply()
        sharedPrefs.edit().putBoolean(prefIsPhoneSavedKey, true).apply()

    }

    private fun isPhoneNumber(phoneStr: String) : Boolean = phoneStr.startsWith("+") && phoneStr.drop(1).isDigitsOnly() && phoneStr.length == 13

}