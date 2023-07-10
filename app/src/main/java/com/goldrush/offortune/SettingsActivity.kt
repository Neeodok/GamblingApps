package com.goldrush.offortune

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import com.goldrush.offortune.databinding.SettingsScreenBinding

class SettingsActivity:AppCompatActivity() {

    private val binding by lazy { SettingsScreenBinding.inflate(layoutInflater)}

    private val prefs by lazy {  getSharedPreferences(sharedPrefsKey, MODE_PRIVATE) }

    private val rbSoundOn by lazy { binding.soundOn }
    private val rbMusicOn by lazy { binding.musicOn }
    private val rbMusicOff by lazy { binding.musicOff }
    private val rbSoundOff by lazy { binding.soundOff }
    private val rgSound by lazy { binding.rd }
    private var iddd = 0

    private val isSoundOn by lazy { prefs.getBoolean(prefSoundOnKey,true) }
    private val isMusicOn by lazy { prefs.getBoolean(prefMusicOnKey,true) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnResScore.setOnClickListener {
            prefs.edit {
                putInt(prefBetKey, 10)
                putInt(prefBankKey, 1000)
                putInt(prefTotalWin, 0)
                apply()
            }

            Toast.makeText(this, "score deleted", Toast.LENGTH_SHORT).show()
        }


        getvalues()

        rbSoundOn.setOnClickListener {
            prefs.edit().putBoolean(prefSoundOnKey, true).apply()
        }

        rbSoundOff.setOnClickListener {
            prefs.edit().putBoolean(prefSoundOnKey, false).apply()

        }

        rbMusicOn.setOnClickListener {
            prefs.edit().putBoolean(prefMusicOnKey, true).apply()

        }

        rbMusicOff.setOnClickListener {
            prefs.edit().putBoolean(prefMusicOnKey, false).apply()
        }

    }
    private fun getvalues (){

        rbSoundOn.isChecked = isSoundOn
        rbSoundOff.isChecked = !isSoundOn
        rbMusicOn.isChecked = isMusicOn
        rbMusicOff.isChecked = !isMusicOn

    }

}