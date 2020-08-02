package com.mobishop.toplixe.activity

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.MediaPlayer.OnCompletionListener
import android.os.Bundle
import android.os.Handler
import android.view.animation.LinearInterpolator
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.mobishop.toplixe.R
import com.mobishop.toplixe.common.Const.Companion.HOST_MUSIC
import com.mobishop.toplixe.model.song.SongEntityModel
import kotlinx.android.synthetic.main.activity_song_detail.*
import java.io.IOException
import java.text.SimpleDateFormat


class SongDetailActivity : AppCompatActivity() {
    var mediaPlayer: MediaPlayer? = MediaPlayer()
    private var songEntityModel: SongEntityModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song_detail)

        addEvents()
    }

    private fun addEvents() {
        var intent = intent
        songEntityModel = intent.getSerializableExtra("DETAIL") as SongEntityModel

        //start dia nhac
        var animator: ObjectAnimator =
            ObjectAnimator.ofFloat(imgDiaNhac, "rotation", 0f, 360f) //rotation thuoc tinh xoay
        animator.duration = 10000 // thoi gian xoay dia nhac
        animator.repeatCount = ValueAnimator.INFINITE
        animator.repeatMode = ValueAnimator.RESTART
        animator.interpolator = LinearInterpolator()
        animator.start()

        Glide.with(applicationContext).load(songEntityModel !!.songEntity.img).into(imgDiaNhac)

        mediaPlayer !!.setAudioStreamType(AudioManager.STREAM_MUSIC)
        try {
            //mediaPlayer !!.setDataSource(songEntityModel.songEntity.uploadsource)
            mediaPlayer !!.setDataSource(HOST_MUSIC + songEntityModel !!.songEntity.uploadsource)
            // Prepare the media player
            mediaPlayer !!.prepare()
//
//            // Start playing audio from http url
            mediaPlayer !!.start()

            mediaPlayer?.seekTo(1)
            imgPlay.setImageResource(R.drawable.ic_pause)
        } catch (e: IOException) {
            // Catch the exception
            e.printStackTrace()
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
        } catch (e: SecurityException) {
            e.printStackTrace()
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        }

        mediaPlayer !!.setOnCompletionListener(OnCompletionListener {
//            Toast.makeText(
//                applicationContext,
//                "End",
//                Toast.LENGTH_SHORT
//            ).show()
        })
        val simpleDateFormat = SimpleDateFormat("mm:ss")
        txtTimeTotalSong.text =
            simpleDateFormat.format(mediaPlayer !!.duration) + "" //lay tong thoi gian cua bai hat

        seekBarSong.max = mediaPlayer !!.duration

        imgPlay.setOnClickListener {
            if (mediaPlayer !!.isPlaying) {
                mediaPlayer !!.pause()
                imgPlay.setImageResource(R.drawable.ic_play)
            } else {
                mediaPlayer !!.start()
                animator.start();
                imgPlay.setImageResource(R.drawable.ic_pause)
            }
        }

        updateTime()

        seekBarSong.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(
                seekBar: SeekBar,
                progress: Int,
                fromUser: Boolean
            ) {
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                mediaPlayer !!.seekTo(seekBar.progress)
            }
        })
    }

    private fun updateTime() {
        val handler = Handler()
        handler.postDelayed(object : Runnable {
            override fun run() {
                if (mediaPlayer != null) {
                    seekBarSong.progress = mediaPlayer !!.currentPosition
                    val simpleDateFormat =
                        SimpleDateFormat("mm:ss")
                    txtTimeSong.text = "" + simpleDateFormat.format(mediaPlayer !!.currentPosition)
                    handler.postDelayed(this, 300)
                    mediaPlayer !!.setOnCompletionListener {
                        try {
                            Thread.sleep(1000)
                            imgPlay.setImageResource(R.drawable.ic_play)
                        } catch (e: InterruptedException) {
                            e.printStackTrace()
                        }
                    }
                }
            }
        }, 500)
    }
}