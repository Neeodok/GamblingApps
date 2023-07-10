package com.goldrush.offortune.games

import android.content.Context
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import com.goldrush.offortune.R
var isSoundOn = true


fun doSounds(activity: AppCompatActivity,sound: SoundConst){
    if (isSoundOn){
        when(sound){
            SoundConst.SPIN -> {
                MediaPlayer.create(activity, R.raw.sound_btn_start).start()
            }
            SoundConst.PLUS -> {
                MediaPlayer.create(activity, R.raw.sound_btn_bet).start()
            }
            SoundConst.VIEW -> {
                MediaPlayer.create(activity, R.raw.sound_view_roulett).start()
            }
            else -> {}
        }
    }
}

enum class SoundConst {
    SPIN, PLUS, VIEW, PICS
}