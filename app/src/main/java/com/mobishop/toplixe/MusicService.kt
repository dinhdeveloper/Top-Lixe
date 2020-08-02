package com.mobishop.toplixe

import android.app.Service
import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.IBinder
import android.os.PowerManager
import com.mobishop.toplixe.model.song.SongEntityModel


class MusicService : Service(), MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener,
    MediaPlayer.OnCompletionListener {

    //media player
    private var player: MediaPlayer? = null

    //song list
    private val songs: ArrayList<SongEntityModel>? = null

    //current position
    private var songPosn = 0

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onPrepared(mp: MediaPlayer?) {
        TODO("Not yet implemented")
    }

    override fun onError(mp: MediaPlayer?, what: Int, extra: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun onCompletion(mp: MediaPlayer?) {
        TODO("Not yet implemented")
    }

    override fun onCreate() {
        //create the service
        super.onCreate()
        songPosn = 0
        player = MediaPlayer()
    }
    fun initMusicPlayer() {
        player?.setWakeMode(getApplicationContext(),
            PowerManager.PARTIAL_WAKE_LOCK);
        player?.setAudioStreamType(AudioManager.STREAM_MUSIC);
    }
}