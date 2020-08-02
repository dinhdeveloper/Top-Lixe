package com.mobishop.toplixe.fragment.song

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobishop.toplixe.R
import com.mobishop.toplixe.activity.SongDetailActivity
import com.mobishop.toplixe.adapter.home.SongSuggressHomeAdapter
import com.mobishop.toplixe.adapter.song.AlbumSongAdapter
import com.mobishop.toplixe.adapter.song.SingerPageSongAdapter
import com.mobishop.toplixe.adapter.song.SongNewApdapter
import com.mobishop.toplixe.fragment.actor.ActorActivity
import com.mobishop.toplixe.fragment.actor.SingerActivity
import com.mobishop.toplixe.viewmodel.fragment.home.SongSuggresstionHomeViewModel
import com.mobishop.toplixe.viewmodel.fragment.song.SingerPageSongViewModel
import com.mobishop.toplixe.viewmodel.fragment.song.SongAlbumViewModel
import com.mobishop.toplixe.viewmodel.fragment.song.SongNewViewModel
import kotlinx.android.synthetic.main.fragment_song.*

class SongFragment : Fragment() {

    private var songViewModel: SongNewViewModel? = null
    private var songHomeAdapter: SongNewApdapter? = null

    private var albumViewModel: SongAlbumViewModel? = null
    private var albumHomeAdapter: AlbumSongAdapter? = null

    private var singerPageSongViewModel : SingerPageSongViewModel?=null
    private var singerAdapter : SingerPageSongAdapter?=null

    private var songSuggestionVM : SongSuggresstionHomeViewModel? = null
    private var songSongRandomHomeAdapter : SongSuggressHomeAdapter?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var view: View =
            LayoutInflater.from(context).inflate(R.layout.fragment_song, container, false)

        getSongTop10()
        getAllAlbum()
        getPageSinger()
        loadSongSuggress()
        return view
    }

    private fun getSongTop10() {
        songViewModel = ViewModelProviders.of(this).get(SongNewViewModel::class.java)
        songViewModel!!.getData()?.observe(this, Observer {
            card_hot.visibility = View.VISIBLE
            rc_listHot.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            rc_listHot.adapter = SongNewApdapter(context, it, itemClick = {
                val intent =
                    Intent(this.context, SongDetailActivity::class.java)
                intent.putExtra("DETAIL",it)
                startActivity(intent)
            })
            songHomeAdapter?.notifyDataSetChanged()
        })
    }

    private fun getAllAlbum(){
        albumViewModel = ViewModelProviders.of(this).get(SongAlbumViewModel::class.java)
        albumViewModel!!.getData()?.observe(this, Observer {
            card_album.visibility = View.VISIBLE
            rc_album.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            rc_album.adapter = AlbumSongAdapter(context, it, itemClick = {
//                val intent =
//                    Intent(this.context, SongDetailActivity::class.java)
//                intent.putExtra("DETAIL",it)
//                startActivity(intent)
            })
            albumHomeAdapter?.notifyDataSetChanged()
        })
    }

    private fun getPageSinger(){
        singerPageSongViewModel = ViewModelProviders.of(this).get(SingerPageSongViewModel::class.java)
        singerPageSongViewModel!!.getData()?.observe(this, Observer {
            card_singer.visibility = View.VISIBLE
            rc_SingerPage.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            rc_SingerPage.adapter = SingerPageSongAdapter(context, it, itemClick = {
                val intent = Intent(context, SingerActivity::class.java)
                intent.putExtra("Singer",it)
                startActivity(intent)
            })
            singerAdapter?.notifyDataSetChanged()
        })
    }

    private fun loadSongSuggress(){
        songSuggestionVM = ViewModelProviders.of(this).get(SongSuggresstionHomeViewModel::class.java)
        songSuggestionVM!!.getData()?.observe(this, Observer {
            card_singer_goiy.visibility =View.VISIBLE
            rc_Singer_GoiY.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            rc_Singer_GoiY.adapter = SongSuggressHomeAdapter(context, it, itemClick = {
                val intent =
                    Intent(this.context, SongDetailActivity::class.java)
                intent.putExtra("DETAIL",it)
                startActivity(intent)
            })
            songSongRandomHomeAdapter?.notifyDataSetChanged()
        })
    }

}