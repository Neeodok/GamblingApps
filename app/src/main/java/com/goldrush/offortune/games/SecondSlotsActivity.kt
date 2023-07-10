package com.goldrush.offortune.games

import android.animation.ObjectAnimator
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.goldrush.offortune.R
import com.goldrush.offortune.databinding.SecondSlotsScreensBinding
import com.goldrush.offortune.prefBankKey
import com.goldrush.offortune.prefBetKey
import com.goldrush.offortune.prefSoundOnKey
import com.goldrush.offortune.prefTotalWin
import com.goldrush.offortune.sharedPrefsKey
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.random.Random

class SecondSlotsActivity : AppCompatActivity() {

    private val binding by lazy { SecondSlotsScreensBinding.inflate(layoutInflater) }

    private val btnStartSppin by lazy { binding.btnSpinStart }
    private val btnUpBet by lazy { binding.btnUpBet }
    private val btnDownBett by lazy { binding.btnDownBet }
    private val tvBankScore by lazy { binding.tvBankScoresss }
    private val tvBets by lazy { binding.tvBetScoress }
    private val tvWinnn by lazy { binding.tvWinScoresss }


    private val matrix = mutableListOf(
        mutableListOf(0, 0, 0, 0, 0),
        mutableListOf(0, 0, 0, 0, 0),
        mutableListOf(0, 0, 0, 0, 0),
        mutableListOf(0, 0, 0, 0, 0)

    )
    private val matrixView by lazy {
        listOf(
            listOf(binding.q0, binding.q1, binding.q2, binding.q3, binding.q4),
            listOf(binding.q5, binding.q6, binding.q7, binding.q8, binding.q9),
            listOf(binding.q10, binding.q11, binding.q12, binding.q13, binding.q14),
            listOf(binding.q15, binding.q16, binding.q17, binding.q18, binding.q19)
        )
    }
    private val drawablecollection = listOf(
        R.drawable.ic2_0,
        R.drawable.ic2_1,
        R.drawable.ic2_2,
        R.drawable.ic2_3,
        R.drawable.ic2_4,
        R.drawable.ic2_5
    )
    private var isClickable = true
    private var animsMatrix = mutableListOf(
        mutableListOf<ObjectAnimator>(),
        mutableListOf<ObjectAnimator>(),
        mutableListOf<ObjectAnimator>(),
        mutableListOf<ObjectAnimator>(),
    )
    private val prefs by lazy { getSharedPreferences(sharedPrefsKey, MODE_PRIVATE) }
    private val isSoundOns by lazy { prefs.getBoolean(prefSoundOnKey, true) }

    private lateinit var viewModel: GameScoresModel

    private lateinit var betLiveData: MutableLiveData<Int>
    private lateinit var bankLiveData: MutableLiveData<Int>
    private lateinit var totalWinLiveData: MutableLiveData<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        isSoundOn=isSoundOns

        startSetOnClickListeners()

        pulseBtnAnimation(binding.btnSpinStart)
        viewModel = ViewModelProvider(this)[GameScoresModel::class.java]

        betLiveData = viewModel.betLD
        bankLiveData = viewModel.bankLD
        totalWinLiveData = viewModel.totalWinLD



        betLiveData.observe(this) {
            tvBets.text = "$it"
            animClickView(tvBets, this)
            prefs.edit().putInt(prefBetKey, betLiveData.value!!).apply()

        }
        bankLiveData.observe(this) {
            tvBankScore.text = "Total \n$it"
            animClickView(tvBankScore, this)
            prefs.edit().putInt(prefBankKey, bankLiveData.value!!).apply()

        }
        totalWinLiveData.observe(this) {
            tvWinnn.text = "WIN \n$it"
            animClickView(tvWinnn, this)
            prefs.edit().putInt(prefTotalWin, totalWinLiveData.value!!).apply()
        }

        betLiveData.value = prefs.getInt(prefBetKey, 10)
        bankLiveData.value = prefs.getInt(prefBankKey, 1000)
        totalWinLiveData.value = prefs.getInt(prefTotalWin, 0)

        animViewWins()

    }

    private fun animViewWins() {
        for (i in 0..4) {
            for (j in 0..3) {
                val rotationX: ObjectAnimator =
                    ObjectAnimator.ofFloat(matrixView[j][i], View.ROTATION_X, 720f)
                rotationX.apply {
                    interpolator = AccelerateDecelerateInterpolator()
                    duration = 1300
                    repeatCount = 2
                }
                animsMatrix[j].add(i, rotationX)
            }
        }

    }

    private fun startSetOnClickListeners() {

        btnStartSppin.setOnClickListener {
            doSounds(this@SecondSlotsActivity,SoundConst.SPIN)
            if (betLiveData.value!! > bankLiveData.value!!) {
                Toast.makeText(this, "Small balance", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            onOffButtons()
            bankLiveData.postValue(bankLiveData.value!!.minus(betLiveData.value!!))


            startBtnAnimation(binding.btnSpinStart)

            CoroutineScope(Dispatchers.Main).launch {

                for (i in 0..3) {
                    for (j in 0..4) {
                        val randomIndex = Random.nextInt(drawablecollection.size)

                        matrixView[i][j].setBackgroundResource(drawablecollection[randomIndex])

                        matrix[i][j] = randomIndex
                        matrixView[i][j].startAnimation(
                            AnimationUtils.loadAnimation(
                                this@SecondSlotsActivity,
                                R.anim.anim_fromtop_slots
                            )

                        )
                        delay(200)

                    }

                }
                delay(400)
                checkForWin()

            }


        }
        btnUpBet.setOnClickListener {
            doSounds(this@SecondSlotsActivity,SoundConst.PLUS)
            startBtnAnimation(btnUpBet)
            if (betLiveData.value!! < bankLiveData.value!!) {
                betLiveData.postValue(betLiveData.value!!.plus(10))

            }
        }
        btnDownBett.setOnClickListener {
            doSounds(this@SecondSlotsActivity,SoundConst.PLUS)
            startBtnAnimation(btnDownBett)
            if (betLiveData.value!! > 10) {
                betLiveData.postValue(betLiveData.value!!.minus(10))
            }
        }
    }

    private fun startBtnAnimation(view: View) {
        animClickView(view, this)
    }


    private fun checkForWin() {
        lifecycleScope.launch(Dispatchers.Main) {

            val winCollection = collectWinners()

            if (winCollection.isNotEmpty()) {
                winCollection.forEach {

                    showWinAnim(it)
                    MediaPlayer.create(this@SecondSlotsActivity, R.raw.sound_slots_moves).start()

                    bankLiveData.postValue(bankLiveData.value!!.plus(betLiveData.value!! * 2))

                    totalWinLiveData.postValue(totalWinLiveData.value!!.plus(betLiveData.value!! * 2))

                    delay(3600)

                }
            }
            if (jackpotsWinners().isNotEmpty()) {
                jackpotsWinners().forEach {
                    showWinAnim(it)
                    MediaPlayer.create(this@SecondSlotsActivity, R.raw.sound_slots_moves).start()


                    bankLiveData.postValue(bankLiveData.value!!.plus(betLiveData.value!! * 20))

                    totalWinLiveData.postValue(totalWinLiveData.value!!.plus(betLiveData.value!! * 20))

                    delay(3800)

                }
            }
            withContext(Dispatchers.Main) { onOffButtons() }
        }

    }

    private fun onOffButtons() {
        isClickable = !isClickable
        btnStartSppin.isClickable = isClickable
        btnUpBet.isClickable = isClickable
        btnDownBett.isClickable = isClickable

    }

    private suspend fun showWinAnim(winList: List<Pair<Int, Int>>) {

        lifecycleScope.launch(Dispatchers.Main) {
            delay(200)
            winList.forEach {
                animsMatrix[it.first][it.second].start()
            }
        }
    }


    private fun is0line() = matrix[0].all { it == matrix[0][0] }
    private fun is1line() = matrix[1].all { it == matrix[1][0] }
    private fun is2line() = matrix[2].all { it == matrix[2][0] }
    private fun is3line() = matrix[3].all { it == matrix[3][0] }

    private fun is5line() = matrix[0][1] == matrix[0][2] && matrix[0][2] == matrix[0][3]
    private fun is6line() = matrix[1][1] == matrix[1][2] && matrix[1][2] == matrix[1][3]
    private fun is7line() = matrix[2][1] == matrix[2][2] && matrix[2][2] == matrix[2][3]
    private fun is8line() = matrix[3][1] == matrix[3][2] && matrix[3][2] == matrix[3][3]


    private fun jackpotsWinners(): List<List<Pair<Int, Int>>> {
        val jackpotWinCollection = mutableListOf<List<Pair<Int, Int>>>()
        if (is0line()) jackpotWinCollection.add(
            listOf(
                Pair(0, 0),
                Pair(0, 1),
                Pair(0, 2),
                Pair(0, 3),
                Pair(0, 4)
            )
        )
        if (is1line()) jackpotWinCollection.add(
            listOf(
                Pair(1, 0),
                Pair(1, 1),
                Pair(1, 2),
                Pair(1, 3),
                Pair(1, 4)
            )
        )
        if (is2line()) jackpotWinCollection.add(
            listOf(
                Pair(2, 0),
                Pair(2, 1),
                Pair(2, 2),
                Pair(2, 3),
                Pair(2, 4)
            )
        )
        if (is3line()) jackpotWinCollection.add(
            listOf(
                Pair(3, 0),
                Pair(3, 1),
                Pair(3, 2),
                Pair(3, 3),
                Pair(3, 4)
            )
        )
        if (is5line()) jackpotWinCollection.add(
            listOf(
                Pair(0, 1),
                Pair(0, 2),
                Pair(0, 3)
            )
        )
        if (is6line()) jackpotWinCollection.add(
            listOf(
                Pair(1, 1),
                Pair(1, 2),
                Pair(1, 3)
            )
        )
        if (is7line()) jackpotWinCollection.add(
            listOf(
                Pair(2, 1),
                Pair(2, 2),
                Pair(2, 3)
            )
        )
        if (is8line()) jackpotWinCollection.add(
            listOf(
                Pair(3, 1),
                Pair(3, 2),
                Pair(3, 3)
            )
        )
        return jackpotWinCollection
    }

    private fun collectWinners(): List<List<Pair<Int, Int>>> {
        val winCollection = mutableListOf<List<Pair<Int, Int>>>()
        for (c in 0..6) {
            val sameIndexList = mutableListOf<Pair<Int, Int>>()
            for (i in 0..3) {
                for (j in 0..4) {

                    if (matrix[i][j] == c) sameIndexList.add(Pair(i, j))

                }
            }
            if (sameIndexList.size > 5) winCollection.add(sameIndexList)
        }
        return winCollection
    }

}