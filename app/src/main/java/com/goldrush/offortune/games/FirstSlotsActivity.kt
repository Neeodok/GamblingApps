package com.goldrush.offortune.games

import android.animation.ObjectAnimator
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.goldrush.offortune.R
import com.goldrush.offortune.databinding.FirstSlotsScreenBinding
import com.goldrush.offortune.prefBankKey
import com.goldrush.offortune.prefBetKey
import com.goldrush.offortune.prefSoundOnKey
import com.goldrush.offortune.prefTotalWin
import com.goldrush.offortune.sharedPrefsKey
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.random.Random


class FirstSlotsActivity : AppCompatActivity() {

    private val binding by lazy { FirstSlotsScreenBinding.inflate(layoutInflater) }

    private lateinit var viewModel: GameScoresModel



    private val btnSpin by lazy { binding.btnSpin }

    private val btnBetUpp by lazy { binding.btnUp }
    private val btnBetDowns by lazy { binding.btnDown }
    private val tvBetScore by lazy { binding.tvBetScore }
    private val tvBankScore by lazy { binding.tvBankScore }
    private val tvWinScore by lazy { binding.tvWinScore }
    private val animLottie by lazy { binding.animationWinLottie }
    private var isClickable = false

    private val drawab = listOf(
        R.drawable.ic1_0,
        R.drawable.ic1_1,
        R.drawable.ic1_2,
        R.drawable.ic1_3,
        R.drawable.ic1_4,
        R.drawable.ic1_5,

        )


    private val scrolls by lazy {
        listOf(
            binding.scroll1,
            binding.scroll2,
            binding.scroll3,
            binding.scroll4,
            binding.scroll5,
        )
    }

    private val holderSlots by lazy {
        listOf<ViewGroup>(
            binding.holder1,
            binding.holder2,
            binding.holder3,
            binding.holder4,
            binding.holder5,
        )
    }

    private var firstViewsMatrix = mutableListOf(
        mutableListOf<View>(),
        mutableListOf<View>(),
        mutableListOf<View>(),
        mutableListOf<View>(),
        mutableListOf<View>(),
    )

    private var animsMatrix = mutableListOf(
        mutableListOf<ObjectAnimator>(),
        mutableListOf<ObjectAnimator>(),
        mutableListOf<ObjectAnimator>(),
        mutableListOf<ObjectAnimator>(),
        mutableListOf<ObjectAnimator>(),
    )

    private var lastViewMatrix = mutableListOf(
        mutableListOf<View>(),
        mutableListOf<View>(),
        mutableListOf<View>(),
        mutableListOf<View>(),
        mutableListOf<View>(),
    )

    private var matrix = mutableListOf(
        mutableListOf(0, 0, 0, 0, 0),
        mutableListOf(0, 0, 0, 0, 0),
        mutableListOf(0, 0, 0, 0, 0),
        mutableListOf(0, 0, 0, 0, 0),
        mutableListOf(0, 0, 0, 0, 0),
    )


    private lateinit var betLiveData: MutableLiveData<Int>
    private lateinit var bankLiveData: MutableLiveData<Int>
    private lateinit var totalWinLiveData: MutableLiveData<Int>


    private val prefs by lazy { getSharedPreferences(sharedPrefsKey, MODE_PRIVATE) }

    private val isSoundOns by lazy { prefs.getBoolean(prefSoundOnKey, true) }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        isSoundOn = isSoundOns

        viewModel = ViewModelProvider(this)[GameScoresModel::class.java]

        betLiveData = viewModel.betLD
        bankLiveData = viewModel.bankLD
        totalWinLiveData = viewModel.totalWinLD



        betLiveData.observe(this) {
            tvBetScore.text = "$it"
            animClickView(tvBetScore, this)
            prefs.edit().putInt(prefBetKey, betLiveData.value!!).apply()

        }
        bankLiveData.observe(this) {
            tvBankScore.text = "Total \n$it"
            animClickView(tvBankScore, this)
            prefs.edit().putInt(prefBankKey, bankLiveData.value!!).apply()

        }
        totalWinLiveData.observe(this) {
            tvWinScore.text = "WIN \n$it"
            animClickView(tvWinScore, this)
            prefs.edit().putInt(prefTotalWin, totalWinLiveData.value!!).apply()
        }

        betLiveData.value = prefs.getInt(prefBetKey, 100)
        bankLiveData.value = prefs.getInt(prefBankKey, 10000)
        totalWinLiveData.value = prefs.getInt(prefTotalWin, 0)





        setupScreenSlots()
        setupListeners()
        pulseBtnAnimation(btnSpin)


    }

    private fun setupScreenSlots() {

        for (i in 0..4) {
            val parent = holderSlots[i]

            for (j in 0..4) {
                val itemView = layoutInflater.inflate(R.layout.pointersss, parent, false)
                itemView.setBackgroundResource(drawab[Random.nextInt(drawab.size)])
                parent.addView(itemView)
                firstViewsMatrix[j].add(i, itemView)


                val rotationX: ObjectAnimator =
                    ObjectAnimator.ofFloat(firstViewsMatrix[j][i], View.ROTATION_X, 720f)
                rotationX.apply {
                    interpolator = AccelerateDecelerateInterpolator()
                    duration = 1300
                    repeatCount = 2
                }

                animsMatrix[j].add(i, rotationX)


            }

            for (j in 0..100) {
                val itemView = layoutInflater.inflate(R.layout.pointersss, parent, false)
                itemView.setBackgroundResource(drawab[Random.nextInt(drawab.size)])
                parent.addView(itemView)
            }

            for (j in 0..4) {

                val index = Random.nextInt(drawab.size)

                val itemView = layoutInflater.inflate(R.layout.pointersss, parent, false)
                itemView.setBackgroundResource(drawab[index])
                parent.addView(itemView)

                lastViewMatrix[j].add(i, itemView)
                matrix[j][i] = index

            }
        }

    }

    private fun setLastViews() {
        for (i in 0..4) {
            for (j in 0..4) {

                val index = Random.nextInt(drawab.size)

                lastViewMatrix[i][j].setBackgroundResource(drawab[index])
                matrix[i][j] = index
            }
        }
    }

    private fun setResultIconsToTheStart() {
        for (i in 0..4) {
            for (j in 0..4) {
                firstViewsMatrix[i][j].setBackgroundResource(drawab[matrix[i][j]])
            }
        }
    }

    private fun setupListeners() {
        btnSpin.setOnClickListener {
            doSounds(this@FirstSlotsActivity,SoundConst.SPIN)
            if (betLiveData.value!! > bankLiveData.value!!) {
                Toast.makeText(this, "Small balance", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            bankLiveData.postValue(bankLiveData.value!!.minus(betLiveData.value!!))


            lifecycleScope.launch(Dispatchers.Main) {
                onOffButtons()

                for (i in 0..7) {
                    withContext(Dispatchers.Main) {
                        setLastViews()
                    }

                    scrolls.forEach {
                        it.isSmoothScrollingEnabled = true
                        it.fullScroll(View.FOCUS_DOWN)
                    }

                    delay(300)

                    withContext(Dispatchers.Main) { setResultIconsToTheStart() }

                    scrolls.forEach {
                        it.isSmoothScrollingEnabled = false
                        it.fullScroll(View.FOCUS_UP)
                    }


                    delay(200)
                }
                checkForWiner()

            }
        }


        btnBetUpp.setOnClickListener {
            doSounds(this@FirstSlotsActivity,SoundConst.PLUS)
            animClickView(btnBetUpp, this)
            if (betLiveData.value!! < bankLiveData.value!!) {
                betLiveData.postValue(betLiveData.value!!.plus(10))

            }
        }
        btnBetDowns.setOnClickListener {
            doSounds(this@FirstSlotsActivity,SoundConst.PLUS)
            animClickView(btnBetDowns, this)
            if (betLiveData.value!! > 10) {
                betLiveData.postValue(betLiveData.value!!.minus(10))
            }
        }
    }


    private fun checkForWiner() {
        lifecycleScope.launch(Dispatchers.Main) {

            val winCollection = collectWinners()
            val jackpot = jackpotcollectWinners()

            if (winCollection.isNotEmpty()) {
                winCollection.forEach {

                    showWinAnim(it)

                    doSounds(this@FirstSlotsActivity,SoundConst.VIEW)
                    animLottie.visibility = View.VISIBLE

                    bankLiveData.postValue(bankLiveData.value!!.plus(betLiveData.value!! * 10))

                    totalWinLiveData.postValue(totalWinLiveData.value!!.plus(betLiveData.value!! * 10))

                    delay(3800)
                    animLottie.visibility = View.INVISIBLE

                }
            }
            if (jackpot.isNotEmpty()) {
                jackpot.forEach {
                    showWinAnim(it)
                    doSounds(this@FirstSlotsActivity,SoundConst.VIEW)

                    animLottie.visibility = View.VISIBLE

                    bankLiveData.postValue(bankLiveData.value!!.plus(betLiveData.value!! * 100))

                    totalWinLiveData.postValue(totalWinLiveData.value!!.plus(betLiveData.value!! * 100))

                    delay(3800)
                    animLottie.visibility = View.INVISIBLE
                }
            }
            onOffButtons()
        }
    }


    private suspend fun showWinAnim(winList: List<Pair<Int, Int>>) {
        lifecycleScope.launch(Dispatchers.Main) {
            delay(200)
            winList.forEach {
                animsMatrix[it.first][it.second].start()
            }
        }
    }

    private suspend fun onOffButtons() {
        withContext(Dispatchers.Main) {
            btnSpin.isClickable = isClickable
            btnBetUpp.isClickable = isClickable
            btnBetDowns.isClickable = isClickable
            isClickable = !isClickable

        }
    }

    private fun is0line() = matrix[0].all { it == matrix[0][0] }
    private fun is1line() = matrix[1].all { it == matrix[1][0] }
    private fun is2line() = matrix[2].all { it == matrix[2][0] }
    private fun is3line() = matrix[3].all { it == matrix[3][0] }
    private fun is4line() = matrix[4].all { it == matrix[4][0] }
    private fun is5line() = matrix[0][1] == matrix[0][2] && matrix[0][2] == matrix[0][3]
    private fun is6line() = matrix[1][1] == matrix[1][2] && matrix[1][2] == matrix[1][3]
    private fun is7line() = matrix[2][1] == matrix[2][2] && matrix[2][2] == matrix[2][3]
    private fun is8line() = matrix[3][1] == matrix[3][2] && matrix[3][2] == matrix[3][3]
    private fun is9line() = matrix[4][1] == matrix[4][2] && matrix[4][2] == matrix[4][3]
    private fun is10line() =
        matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2] && matrix[2][2] == matrix[3][3] && matrix[3][3] == matrix[4][4]

    private fun is11line() =
        matrix[0][4] == matrix[1][3] && matrix[1][3] == matrix[2][2] && matrix[2][2] == matrix[3][1] && matrix[3][1] == matrix[4][0]


    private fun collectWinners(): List<List<Pair<Int, Int>>> {
        val winCollection = mutableListOf<List<Pair<Int, Int>>>()
        if (is5line()) winCollection.add(
            listOf(
                Pair(0, 1),
                Pair(0, 2),
                Pair(0, 3)
            )
        )
        if (is6line()) winCollection.add(
            listOf(
                Pair(1, 1),
                Pair(1, 2),
                Pair(1, 3)
            )
        )
        if (is7line()) winCollection.add(
            listOf(
                Pair(2, 1),
                Pair(2, 2),
                Pair(2, 3)
            )
        )
        if (is8line()) winCollection.add(
            listOf(
                Pair(3, 1),
                Pair(3, 2),
                Pair(3, 3)
            )
        )
        if (is9line()) winCollection.add(
            listOf(
                Pair(4, 1),
                Pair(4, 2),
                Pair(4, 3)
            )
        )
        if (is0line()) winCollection.add(
            listOf(
                Pair(0, 0),
                Pair(0, 1),
                Pair(0, 2),
                Pair(0, 3),
                Pair(0, 4)
            )
        )
        if (is1line()) winCollection.add(
            listOf(
                Pair(1, 0),
                Pair(1, 1),
                Pair(1, 2),
                Pair(1, 3),
                Pair(1, 4)
            )
        )
        if (is2line()) winCollection.add(
            listOf(
                Pair(2, 0),
                Pair(2, 1),
                Pair(2, 2),
                Pair(2, 3),
                Pair(2, 4)
            )
        )
        if (is3line()) winCollection.add(
            listOf(
                Pair(3, 0),
                Pair(3, 1),
                Pair(3, 2),
                Pair(3, 3),
                Pair(3, 4)
            )
        )
        if (is4line()) winCollection.add(
            listOf(
                Pair(4, 0),
                Pair(4, 1),
                Pair(4, 2),
                Pair(4, 3),
                Pair(4, 4)
            )
        )
        return winCollection
    }

    private fun jackpotcollectWinners(): List<List<Pair<Int, Int>>> {
        val jackpotwinCollection = mutableListOf<List<Pair<Int, Int>>>()
        if (is10line()) jackpotwinCollection.add(
            listOf(
                Pair(0, 0),
                Pair(1, 1),
                Pair(2, 2),
                Pair(3, 3),
                Pair(4, 4)
            )
        )
        if (is11line()) jackpotwinCollection.add(
            listOf(
                Pair(0, 4),
                Pair(1, 3),
                Pair(2, 2),
                Pair(3, 1),
                Pair(4, 0)
            )
        )
        return jackpotwinCollection
    }

}