package com.goldrush.offortune

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.goldrush.offortune.databinding.MenuScreenBinding
import com.goldrush.offortune.games.SoundConst
import com.goldrush.offortune.games.doSounds
import com.goldrush.offortune.games.isSoundOn

class MenuActivity:AppCompatActivity() {

    private val binding by lazy { MenuScreenBinding.inflate(layoutInflater) }
    private val btnChooseGame by lazy {binding.btnChoosegame  }
    private val btnPrivacy by lazy {binding.btnPrivacy  }
    private val btnSettings by lazy {binding.btnSettings  }
    private val btnBack by lazy {binding.btnExit  }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        btnChooseGame.setOnClickListener {
            val intent = Intent(this@MenuActivity, ChooseGameActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.diagonaltranslate,R.anim.alpha)
        }
        btnPrivacy.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"))
            startActivity(browserIntent)

        }
        btnSettings.setOnClickListener {
            val intent = Intent(this@MenuActivity, SettingsActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.diagonaltranslate,R.anim.alpha)
        }

        btnBack.setOnClickListener {
            onBackPressed()
        }

    }

}