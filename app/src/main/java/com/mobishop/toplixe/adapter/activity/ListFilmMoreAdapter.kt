package com.mobishop.toplixe.adapter.activity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mobishop.toplixe.R
import com.mobishop.toplixe.model.film.FilmEntityModel

class ListFilmMoreAdapter(
    private val context: Context?,
    private val listFilmDetail: List<FilmEntityModel>,
    private val itemClick: (FilmEntityModel) -> Unit
) : RecyclerView.Adapter<ListFilmMoreAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view =
            LayoutInflater.from(context)
                .inflate(R.layout.custom_item_film_load_more, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int {
       return listFilmDetail.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (context !=null && listFilmDetail.isNotEmpty()){
            Glide.with(context).load(listFilmDetail[position].filmEntity!!.img)
                .error(R.drawable.loading_image)
                .into(holder.imageFilm)

            holder.nameFilm.text = listFilmDetail[position].filmEntity!!.filmname
            holder.countryName.text = listFilmDetail[position].filmEntity!!.country
        }
    }
    inner  class ViewHolder(item: View, private val itemClick: (FilmEntityModel) -> Unit) :
        RecyclerView.ViewHolder(item)  {
        var imageFilm : ImageView = item.findViewById(R.id.imageFilm)
        var nameFilm : TextView = item.findViewById(R.id.nameFilm)
        var countryName : TextView = item.findViewById(R.id.countryName)
    }

}