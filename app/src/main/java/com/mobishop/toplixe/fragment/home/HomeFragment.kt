package com.mobishop.toplixe.fragment.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobishop.toplixe.R
import com.mobishop.toplixe.activity.FilmDetailActivity
import com.mobishop.toplixe.activity.SongDetailActivity
import com.mobishop.toplixe.adapter.home.*
import com.mobishop.toplixe.viewmodel.fragment.home.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private var songViewModel: FragmentHomeViewModel? = null
    private var songHomeAdapter: SongHomeAdapter? = null

    private var filmNewViewModel: FilmNewHomeViewModel? = null
    private var filmNewHomeAdapter: FilmNewHomeAdapter? = null

    private var songRandomHomeViewModel: SongRandomHomeViewModel? = null
    private var songRandomHomeAdapter: SongRandomHomeAdapter? = null

    private var filmSuggestionVM : FilmSuggestionHomeViewModel? = null
    private var filmSugAdapters : FilmSuggrestionHomeAdapter? = null

    private var songSuggestionVM : SongSuggresstionHomeViewModel? = null
    private var songSongRandomHomeAdapter : SongSuggressHomeAdapter?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       var view :View = LayoutInflater.from(context).inflate(R.layout.fragment_home, container, false)

        loadSongRandom()
        loadSongHome()
        loadFilmNewHome()
        loadFilmSugges()
        loadSongSuggress()
        
        return view
    }


    private fun loadSongRandom(){
        songRandomHomeViewModel = ViewModelProviders.of(this).get(SongRandomHomeViewModel::class.java)
        songRandomHomeViewModel!!.getData()?.observe(this, Observer {
            card_nghegi.visibility =View.VISIBLE
            rc_songrandom.layoutManager = GridLayoutManager(context,3)
            rc_songrandom.adapter = SongRandomHomeAdapter(context, it, itemClick = {
                val intent =
                    Intent(this.context, SongDetailActivity::class.java)
                intent.putExtra("DETAIL",it)
                intent.flags =
                    Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intent)
            })
            songRandomHomeAdapter?.notifyDataSetChanged()
        })
    }

    private fun loadSongHome() {
        songViewModel = ViewModelProviders.of(this).get(FragmentHomeViewModel::class.java)
        songViewModel!!.getData()?.observe(this, Observer {
            card_musicrank.visibility =View.VISIBLE
            rc_musicrank.layoutManager = GridLayoutManager(context,3)
            rc_musicrank.adapter = SongHomeAdapter(context, it, itemClick = {
                val intent =
                    Intent(this.context, SongDetailActivity::class.java)
                intent.putExtra("DETAIL",it)
                Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intent)
            })
            songHomeAdapter?.notifyDataSetChanged()
        })
    }
    private fun loadFilmNewHome(){
        filmNewViewModel = ViewModelProviders.of(this).get(FilmNewHomeViewModel::class.java)
        filmNewViewModel!!.getData()?.observe(this, Observer {
            card_filmnew.visibility =View.VISIBLE
            rc_filmnew.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            rc_filmnew.adapter = FilmNewHomeAdapter(context, it, itemClick = {
                val intent =
                    Intent(this.context, FilmDetailActivity::class.java)
                intent.putExtra("FILM",it)
                startActivity(intent)
            })
            filmNewHomeAdapter?.notifyDataSetChanged()
        })
    }

    private fun loadFilmSugges(){
        filmSuggestionVM = ViewModelProviders.of(this).get(FilmSuggestionHomeViewModel::class.java)
        filmSuggestionVM!!.getData()?.observe(this, Observer {
            card_film_goiy.visibility =View.VISIBLE
            rc_film_goiy.layoutManager =
                GridLayoutManager(activity, 3)
            rc_film_goiy.adapter = FilmSuggrestionHomeAdapter(context, it, itemClick = {
                val intent = Intent(context, FilmDetailActivity::class.java)
                intent.putExtra("FILM", it)
                startActivity(intent)
            })
            filmSugAdapters?.notifyDataSetChanged()
        })
    }
    private fun loadSongSuggress(){
        songSuggestionVM = ViewModelProviders.of(this).get(SongSuggresstionHomeViewModel::class.java)
        songSuggestionVM!!.getData()?.observe(this, Observer {
            card_song_goiy.visibility =View.VISIBLE
            rc_song_goiy.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            rc_song_goiy.adapter = SongSuggressHomeAdapter(context, it, itemClick = {
                val intent =
                    Intent(this.context, SongDetailActivity::class.java)
                intent.putExtra("DETAIL",it)
                startActivity(intent)
            })
            songSongRandomHomeAdapter?.notifyDataSetChanged()
        })
    }
}