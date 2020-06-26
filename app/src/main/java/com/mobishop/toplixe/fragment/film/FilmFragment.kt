package com.mobishop.toplixe.fragment.film

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobishop.toplixe.R
import com.mobishop.toplixe.activity.FilmDetailActivity
import com.mobishop.toplixe.adapter.film.FilmActorAdapter
import com.mobishop.toplixe.adapter.film.FilmHasPageAdapter
import com.mobishop.toplixe.adapter.film.FilmHotAdapter
import com.mobishop.toplixe.adapter.film.FilmSuggestionAdapter
import com.mobishop.toplixe.viewmodel.fragment.film.FilmActorViewModel
import com.mobishop.toplixe.viewmodel.fragment.film.FilmHasPageViewModel
import com.mobishop.toplixe.viewmodel.fragment.film.FilmHotViewModel
import com.mobishop.toplixe.viewmodel.fragment.film.FilmSuggestionViewModel
import kotlinx.android.synthetic.main.fragment_film.*

class FilmFragment : Fragment() {

    private var filmHotViewModel: FilmHotViewModel? = null
    private var filmHotAdapter: FilmHotAdapter? = null

    private var filmSuggestionViewModel : FilmSuggestionViewModel? = null
    private var filmSugAdapter: FilmSuggestionAdapter? = null

    private var filmActorViewModel : FilmActorViewModel? = null
    private var filmActorAdapter: FilmActorAdapter? = null

    private var filmHasViewModel : FilmHasPageViewModel? = null
    private var filmHasAdapter: FilmHasPageAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

       var view :View = LayoutInflater.from(context).inflate(R.layout.fragment_film, container, false)

        callFilmHot()
        callGoiYChoBan()
        callActor()
        callFilmHasPage()

        return view
    }
    private fun callFilmHot(){
        filmHotViewModel = ViewModelProviders.of(this).get(FilmHotViewModel::class.java)
        filmHotViewModel!!.getData()?.observe(this, Observer {
            card_hot.visibility =View.VISIBLE
            rc_listHot.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            rc_listHot.adapter = FilmHotAdapter(context, it, itemClick = { it ->
                val intent = Intent(context, FilmDetailActivity::class.java)
                intent.putExtra("FILM", it)
                startActivity(intent)
            })
            filmHotAdapter?.notifyDataSetChanged()
            shimmer_view_product?.stopShimmer()
            shimmer_view_product?.visibility = View.GONE
        })
//        film_hot_more.setOnClickListener {
//
//        }
    }
    private fun callGoiYChoBan(){
        filmSuggestionViewModel = ViewModelProviders.of(this).get(FilmSuggestionViewModel::class.java)
        filmSuggestionViewModel!!.getData()?.observe(this, Observer {
            card_recommend.visibility =View.VISIBLE
            rc_listSuggest.layoutManager =
                GridLayoutManager(activity, 2, GridLayoutManager.VERTICAL, false)
            rc_listSuggest.adapter = FilmSuggestionAdapter(context, it, itemClick = {
                val intent = Intent(context, FilmDetailActivity::class.java)
                intent.putExtra("FILM", it)
                startActivity(intent)
            })
            filmSugAdapter?.notifyDataSetChanged()
        })
    }

    private fun callActor(){
        filmActorViewModel = ViewModelProviders.of(this).get(FilmActorViewModel::class.java)
        filmActorViewModel!!.getData()?.observe(this, Observer {
            card_actor.visibility =View.VISIBLE
            rc_actor.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            rc_actor.adapter = FilmActorAdapter(context, it, itemClick = {

            })
            filmActorAdapter?.notifyDataSetChanged()
        })
    }

    private fun callFilmHasPage(){
        filmHasViewModel = ViewModelProviders.of(this).get(FilmHasPageViewModel::class.java)
        filmHasViewModel!!.getData()?.observe(this, Observer {
            rc_listFilm.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            rc_listFilm.adapter = FilmHasPageAdapter(context, it, itemClick = {
                val intent = Intent(context, FilmDetailActivity::class.java)
                intent.putExtra("FILM", it)
                startActivity(intent)
            })
            //them duong ke ơ giữa
            val dividerHorizontal =
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            context?.resources?.getDrawable(R.drawable.custom_line_rc)?.let { it1 ->
                dividerHorizontal.setDrawable(
                    it1
                )
            }
            rc_listFilm.addItemDecoration(dividerHorizontal)
            filmHasAdapter?.notifyDataSetChanged()
        })
    }


    override fun onResume() {
        super.onResume()
        shimmer_view_product.startShimmer()
    }

    override fun onPause() {
        shimmer_view_product.stopShimmer()
        super.onPause()
    }
}