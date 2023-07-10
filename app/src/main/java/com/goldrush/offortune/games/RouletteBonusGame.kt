package com.goldrush.offortune.games

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import androidx.appcompat.app.AppCompatActivity
import com.goldrush.offortune.R
import com.goldrush.offortune.databinding.RouletteScreenWinBinding
import com.goldrush.offortune.prefSoundOnKey
import com.goldrush.offortune.sharedPrefsKey
import kotlin.random.Random

class RouletteBonusGame : AppCompatActivity() {


    private val binding by lazy { RouletteScreenWinBinding.inflate(layoutInflater) }
    private val prefs by lazy { getSharedPreferences(sharedPrefsKey, MODE_PRIVATE) }
    private val isSoundOn by lazy { prefs.getBoolean(prefSoundOnKey, true) }

    private var isInProcess = false

    private var toSector = 0

    private var bet = 20
    private var bank = 10000

    private var betId = 0

    private val coeff = 36f

    var toNewSectorGradus = 0f

    private var fromDegrees = 0f

    private val items by lazy {
        listOf(
            binding.convert0,
            binding.convert1,
            binding.convert2,
            binding.convert3,
            binding.convert4,
            binding.convert5,
            binding.convert6,
            binding.convert7,
            binding.convert8,
            binding.convert9,
        )
    }
    private val images = listOf(
        R.drawable.roulette_q0,
        R.drawable.roulette_q1,
        R.drawable.roulette_q2,
        R.drawable.roulette_q3,
        R.drawable.roulette_q0,
        R.drawable.roulette_q1,
        R.drawable.roulette_q2,
        R.drawable.roulette_q3,
        R.drawable.roulette_q0,
        R.drawable.roulette_q2,
    )

    private val xoef = listOf(
        1,
        2,
        3,
        0,
        1,
        2,
        3,
        0,
        1,
        2,
    )


    private val mainWheel by lazy { binding.wheelRoulette }
    private val btnRoll by lazy { binding.btnSpin }
    private val tvBonus by lazy { binding.tvBonus }
    private val btnBetNUp by lazy { binding.btnPlus }
    private val btnBetNDown by lazy { binding.btnMinus }
    //private val tvShowBank by lazy { binding.tvbank }
    private val tvShowChosenBet by lazy { binding.tvBet }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        //tvShowBank.text = bank.toString()
        tvShowChosenBet.text = bet.toString()
        animbtnRoll()




        btnRoll.setOnClickListener {
            doSound(SoundConst.SPIN)
            if (!isInProcess) {
                isInProcess = true
                toSector = Random.nextInt(0, 9)
                toNewSectorGradus = (toSector * coeff)
                val additionalRolls = 7 * 360
                val toFinalDegree = additionalRolls + toNewSectorGradus
                rotateWheel(toFinalDegree)
            }

        }

        btnBetNUp.setOnClickListener {
            doSound(SoundConst.PLUS)
            if (bet < bank) {
                bet += 10
                tvShowChosenBet.text = bet.toString()
                animateTextVIew(it)


            }
        }
        btnBetNDown.setOnClickListener {
            doSound(SoundConst.PLUS)
            if (bet >= 20) {
                bet -= 10
                tvShowChosenBet.text = bet.toString()
                animateTextVIew(it)
            }
        }

    }

    private fun animateTextVIew(it: View) {
        animClickView(it, this)
    }

    private fun rotateWheel(toFinalDegrees: Float) {

        val rotationAnim = RotateAnimation(
            fromDegrees,
            toFinalDegrees,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        rotationAnim.duration = 3200
        rotationAnim.fillAfter = true
        rotationAnim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(p0: Animation?) {
            }

            override fun onAnimationEnd(p0: Animation?) {
                fromDegrees = toNewSectorGradus

                isInProcess = false
                btnRoll.isClickable = true
                winAnimation(items[toSector], this@RouletteBonusGame)
                doSound(SoundConst.VIEW)
            }

            override fun onAnimationRepeat(p0: Animation?) {
            }

        })

        mainWheel.startAnimation(rotationAnim)

    }

    private fun animbtnRoll() {
        val animScaleX = ObjectAnimator.ofFloat(btnRoll, View.SCALE_X, 0.95f, 1.0f)
        animScaleX.apply {
            duration = 700
            interpolator = AccelerateDecelerateInterpolator()
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.REVERSE
        }
        val animScaleY = ObjectAnimator.ofFloat(btnRoll, View.SCALE_Y, 0.95f, 1.0f)
        animScaleY.apply {
            duration = 700
            interpolator = AccelerateDecelerateInterpolator()
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.REVERSE
        }

        animScaleX.start()
        animScaleY.start()

        fun animTv() {
            val animScaleX = ObjectAnimator.ofFloat(tvBonus, View.SCALE_X, 0.95f, 1.0f)
            animScaleX.apply {
                duration = 700
                interpolator = AccelerateDecelerateInterpolator()
                repeatCount = ValueAnimator.INFINITE
                repeatMode = ValueAnimator.REVERSE
            }
            val animScaleY = ObjectAnimator.ofFloat(tvBonus, View.SCALE_Y, 0.95f, 1.0f)
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

    private fun doSound(sound: SoundConst){
        if (isSoundOn){
            when(sound){
                SoundConst.SPIN -> {
                    MediaPlayer.create(this, R.raw.sound_btn_start).start()
                }
                SoundConst.PLUS -> {
                    MediaPlayer.create(this, R.raw.sound_btn_bet).start()
                }
                SoundConst.VIEW -> {
                    MediaPlayer.create(this, R.raw.sound_view_roulett).start()
                }
                else -> {}
            }
        }
    }
}