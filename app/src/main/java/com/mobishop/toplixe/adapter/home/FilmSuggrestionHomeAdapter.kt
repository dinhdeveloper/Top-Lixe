package com.mobishop.toplixe.adapter.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mobishop.toplixe.R
import com.mobishop.toplixe.adapter.film.FilmSuggestionAdapter
import com.mobishop.toplixe.common.CountTime
import com.mobishop.toplixe.model.film.FilmEntityModel

class FilmSuggrestionHomeAdapter(
    private val context: Context?,
    private val listFilm: List<FilmEntityModel>,
    private val itemClick: (FilmEntityModel) -> Unit
) : RecyclerView.Adapter<FilmSuggrestionHomeAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view =
            LayoutInflater.from(context).inflate(R.layout.custom_item_film_load_more, parent, false)
        return ViewHolder(view,itemClick)
    }

    override fun getItemCount(): Int {
        return if (listFilm.size > 4) {
            9
        } else {
            listFilm.size
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (context != null) {
            Glide.with(context).load(R.drawable.bontram).error(R.drawable.empty)
                .into(holder.imageFilm!!)
            holder.nameFilm?.text = listFilm[position].filmEntity?.filmname
            holder.countryName?.text = listFilm[position].filmEntity?.country
        }
    }

    inner class ViewHolder(
        item: View,
        private val itemClick: (FilmEntityModel) -> Unit
    ) : RecyclerView.ViewHolder(item) {
        var imageFilm: ImageView? = itemView?.findViewById(R.id.imageFilm)
        var nameFilm: TextView? = itemView?.findViewById(R.id.nameFilm)
        var countryName: TextView? = itemView?.findViewById(R.id.countryName)
        init {
            itemView?.setOnClickListener {
                itemClick?.invoke(listFilm[adapterPosition])
            }
        }
    }
}