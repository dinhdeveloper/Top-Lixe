package com.mobishop.toplixe.fragment.song

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobishop.toplixe.R
import com.mobishop.toplixe.adapter.home.SongHomeAdapter
import com.mobishop.toplixe.adapter.song.AlbumSongAdapter
import com.mobishop.toplixe.adapter.song.SongNewApdapter
import com.mobishop.toplixe.viewmodel.fragment.home.FragmentHomeViewModel
import com.mobishop.toplixe.viewmodel.fragment.song.SongAlbumViewModel
import com.mobishop.toplixe.viewmodel.fragment.song.SongNewViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_song.*

class SongFragment : Fragment() {

    private var songViewModel: SongNewViewModel? = null
    private var songHomeAdapter: SongNewApdapter? = null

    private var albumViewModel: SongAlbumViewModel? = null
    private var albumHomeAdapter: AlbumSongAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var view: View =
            LayoutInflater.from(context).inflate(R.layout.fragment_song, container, false)

        getSongTop10()
        getAllAlbum()

        return view
    }

    private fun getSongTop10() {
        songViewModel = ViewModelProviders.of(this).get(SongNewViewModel::class.java)
        songViewModel!!.getData()?.observe(this, Observer {
            card_hot.visibility = View.VISIBLE
            rc_listHot.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            rc_listHot.adapter = SongNewApdapter(context, it, itemClick = {
                Toast.makeText(context, "${it.songEntity?.img}", Toast.LENGTH_LONG).show()
            })
            songHomeAdapter?.notifyDataSetChanged()
        })
    }

    private fun getAllAlbum(){
        albumViewModel = ViewModelProviders.of(this).get(SongAlbumViewModel::class.java)
        albumViewModel!!.getData()?.observe(this, Observer {
            card_hot.visibility = View.VISIBLE
            rc_listHot.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            rc_listHot.adapter = AlbumSongAdapter(context, it, itemClick = {
                Toast.makeText(context, "${it.albumEntity?.albumname}", Toast.LENGTH_LONG).show()
            })
            albumHomeAdapter?.notifyDataSetChanged()
        })
    }

}