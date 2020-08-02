package com.mobishop.toplixe.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobishop.toplixe.R
import com.mobishop.toplixe.adapter.film.FilmHasPageAdapter
import com.mobishop.toplixe.adapter.film.FilmHotAdapter
import com.mobishop.toplixe.adapter.film.LoadMoreFilmAdapter
import com.mobishop.toplixe.viewmodel.fragment.film.FilmHasPageViewModel
import com.mobishop.toplixe.viewmodel.fragment.film.FilmHotViewModel
import kotlinx.android.synthetic.main.activity_list_film_more.*

class ListFilmMoreActivity : AppCompatActivity() {

    private var filmHasViewModel : FilmHasPageViewModel? = null
    private var filmHasAdapter: LoadMoreFilmAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_film_more)

        loadFilm()
    }
    private fun loadFilm(){
        filmHasViewModel = ViewModelProviders.of(this).get(FilmHasPageViewModel::class.java)
        filmHasViewModel!!.getData()?.observe(this, Observer {
            rc_load_film_more.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
            rc_load_film_more.adapter = LoadMoreFilmAdapter(applicationContext, it, itemClick = { it ->
                val intent = Intent(applicationContext, FilmDetailActivity::class.java)
                intent.putExtra("FILM", it)
                startActivity(intent)
            })
            filmHasAdapter?.notifyDataSetChanged()
        })
    }
}