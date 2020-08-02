package com.mobishop.toplixe.activity

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import cn.jzvd.JZVideoPlayer
import cn.jzvd.JZVideoPlayerStandard
import com.mobishop.toplixe.R
import com.mobishop.toplixe.adapter.activity.FilmDetailLoadMoreAdapter
import com.mobishop.toplixe.api.APIService
import com.mobishop.toplixe.api.APIUntil
import com.mobishop.toplixe.common.Const.Companion.HOST_MUSIC
import com.mobishop.toplixe.model.film.FilmEntityModel
import com.mobishop.toplixe.viewmodel.activity.FilmDetailLoadMoreViewModel
import kotlinx.android.synthetic.main.activity_film_detail.*

class FilmDetailActivity : AppCompatActivity() {
    private lateinit var apiService: APIService

    private var filmDetailLoadMoreAdapter : FilmDetailLoadMoreAdapter? = null
    private var filmDetailLoadMoreViewModel : FilmDetailLoadMoreViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_detail)
        apiService = APIUntil.server
        getData()
        getDataMore()
    }

    private fun getData() {
        var intent = intent
        var product = intent.getSerializableExtra("FILM") as FilmEntityModel

        if (product != null) {
            videoplayer.setUp(
                "${HOST_MUSIC+product.filmEntity!!.uploadsource.toString()}",
                JZVideoPlayerStandard.SCREEN_STATE_OFF,
                "${product.filmEntity!!.filmname.toString()}"
            )
//            videoplayer.setUp(
//                "http://115.73.214.162:7777/Uploads/satthuthomay.mp4", //http://115.73.214.162:7777/Lixe/uploads/piano.mp4
//                JZVideoPlayerStandard.SCREEN_STATE_OFF,
//                "${product.filmEntity?.filmname.toString()}"
//            )
            txtNameFilm.text = product.filmEntity?.filmname.toString()
            txtDescription.text = product.filmEntity?.info.toString()

            videoplayer.startButton.performClick()
            videoplayer.startVideo()
            JZVideoPlayer.FULLSCREEN_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            JZVideoPlayer.NORMAL_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            JZVideoPlayer.SAVE_PROGRESS = false
        } else {
            JZVideoPlayer.SAVE_PROGRESS = false
            finish()
        }
    }
    private fun getDataMore(){
        filmDetailLoadMoreViewModel = ViewModelProviders.of(this).get(FilmDetailLoadMoreViewModel::class.java)
        filmDetailLoadMoreViewModel!!.getData()?.observe(this, Observer {
            rc_overlap.layoutManager =
                LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
            rc_overlap.adapter = FilmDetailLoadMoreAdapter(applicationContext, it, itemClick = { it ->
                val intent = Intent(applicationContext, FilmDetailActivity::class.java)
                intent.putExtra("FILM", it)
                startActivity(intent)
                finish()
            })
            filmDetailLoadMoreAdapter?.notifyDataSetChanged()
        })
    }
    override fun onPause() {
        super.onPause()
        JZVideoPlayer.SAVE_PROGRESS = false
        JZVideoPlayer.releaseAllVideos()
    }

    override fun onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }
}