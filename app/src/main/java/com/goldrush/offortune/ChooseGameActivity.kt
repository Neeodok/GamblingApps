package com.goldrush.offortune

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.goldrush.offortune.databinding.ChooseGameScreenBinding
import com.goldrush.offortune.games.FirstSlotsActivity
import com.goldrush.offortune.games.RouletteBonusGame
import com.goldrush.offortune.games.SecondSlotsActivity
import com.goldrush.offortune.games.SoundConst
import com.goldrush.offortune.games.doSounds
import com.goldrush.offortune.games.isSoundOn

class ChooseGameActivity : AppCompatActivity() {

    private val binding by lazy { ChooseGameScreenBinding.inflate(layoutInflater) }
    private val btnFirstGame by lazy { binding.btnGame1 }
    private val btnSecondGame by lazy { binding.btnGame2 }
    private val btnThirdGame by lazy { binding.btnGamebonus }
    private val img1 by lazy { binding.img1game }
    private val img2 by lazy { binding.img2game }
    private val prefs by lazy { getSharedPreferences(sharedPrefsKey, MODE_PRIVATE) }
    private val isSoundOns by lazy { prefs.getBoolean(prefSoundOnKey, true) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        isSoundOn =isSoundOns
        startAnim()
        setupOnListeners()


    }

    private fun startAnim() {
        val animScaleX = ObjectAnimator.ofFloat(img1, View.SCALE_X, 0.95f, 1.0f)
        animScaleX.apply {
            duration = 700
            interpolator = AccelerateDecelerateInterpolator()
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.REVERSE
        }
        val animScaleY = ObjectAnimator.ofFloat(img1, View.SCALE_Y, 0.95f, 1.0f)
        animScaleY.apply {
            duration = 700
            interpolator = AccelerateDecelerateInterpolator()
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.REVERSE
        }

        animScaleX.start()
        animScaleY.start()

        fun animTv() {
            val animScaleX = ObjectAnimator.ofFloat(img2, View.SCALE_X, 0.95f, 1.0f)
            animScaleX.apply {
                duration = 700
                interpolator = AccelerateDecelerateInterpolator()
                repeatCount = ValueAnimator.INFINITE
                repeatMode = ValueAnimator.REVERSE
            }
            val animScaleY = ObjectAnimator.ofFloat(img2, View.SCALE_Y, 0.95f, 1.0f)
            animScaleY.apply {
                duration = 700
                interpolator = AccelerateDecelerateInterpolator()
                repeatCount = ValueAnimator.INFINITE
                repeatMode = ValueAnimator.REVERSE
            }

            animScaleX.start()
            animScaleY.start()
        }
        animTv()

    }

    private fun setupOnListeners() {
        btnFirstGame.setOnClickListener {
            doSounds(this@ChooseGameActivity, SoundConst.SPIN)
            val intent = Intent(this@ChooseGameActivity, FirstSlotsActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.diagonaltranslate,R.anim.alpha)
        }
        btnSecondGame.setOnClickListener {
            doSounds(this@ChooseGameActivity, SoundConst.SPIN)
            val intent = Intent(this@ChooseGameActivity, SecondSlotsActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.diagonaltranslate,R.anim.alpha)
        }
        btnThirdGame.setOnClickListener {
            doSounds(this@ChooseGameActivity, SoundConst.SPIN)
            val intent = Intent(this@ChooseGameActivity, RouletteBonusGame::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.diagonaltranslate,R.anim.alpha)
        }
    }

}