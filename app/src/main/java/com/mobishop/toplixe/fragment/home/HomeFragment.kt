package com.mobishop.toplixe.fragment.home

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
import com.mobishop.toplixe.adapter.home.FilmNewHomeAdapter
import com.mobishop.toplixe.adapter.home.SongHomeAdapter
import com.mobishop.toplixe.adapter.home.SongRandomHomeAdapter
import com.mobishop.toplixe.viewmodel.fragment.home.FilmNewHomeViewModel
import com.mobishop.toplixe.viewmodel.fragment.home.FragmentHomeViewModel
import com.mobishop.toplixe.viewmodel.fragment.home.SongRandomHomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private var songViewModel: FragmentHomeViewModel? = null
    private var songHomeAdapter: SongHomeAdapter? = null

    private var filmNewViewModel: FilmNewHomeViewModel? = null
    private var filmNewHomeAdapter: FilmNewHomeAdapter? = null

    private var songRandomHomeViewModel: SongRandomHomeViewModel? = null
    private var songRandomHomeAdapter: SongRandomHomeAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       var view :View = LayoutInflater.from(context).inflate(R.layout.fragment_home, container, false)

        loadSongRandom()
        loadSongHome()
        loadFilmNewHome()
        return view;
    }

    private fun loadSongRandom(){
        songRandomHomeViewModel = ViewModelProviders.of(this).get(SongRandomHomeViewModel::class.java)
        songRandomHomeViewModel!!.getData()?.observe(this, Observer {
            card_nghegi.visibility =View.VISIBLE
            rc_songrandom.layoutManager = GridLayoutManager(context,3)
            rc_songrandom.adapter = SongRandomHomeAdapter(context, it, itemClick = {
                Toast.makeText(context, "${it.songEntity?.img}", Toast.LENGTH_LONG).show()
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
                Toast.makeText(context, "${it.songEntity?.img}", Toast.LENGTH_LONG).show()
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
                Toast.makeText(context, "${it.filmEntity?.img}", Toast.LENGTH_LONG).show()
            })
            filmNewHomeAdapter?.notifyDataSetChanged()
        })
    }
}