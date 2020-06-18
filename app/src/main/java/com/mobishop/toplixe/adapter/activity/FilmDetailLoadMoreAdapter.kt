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

class FilmDetailLoadMoreAdapter(
    private val context: Context?,
    private val listFilmDetail: List<FilmEntityModel>,
    private val itemClick: (FilmEntityModel) -> Unit
) : RecyclerView.Adapter<FilmDetailLoadMoreAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view =
            LayoutInflater.from(context)
                .inflate(R.layout.custom_item_more_film_detail, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int {
        if (listFilmDetail.size % 2 == 0) {
            return listFilmDetail.size
        } else {
            return listFilmDetail.size - 1
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (context != null) {
            Glide.with(context).load(listFilmDetail[position].filmEntity!!.img)
                .into(holder.imgItemFilm!!)
        }
        holder.filmNames?.text = listFilmDetail[position].filmEntity?.filmname
        if (listFilmDetail[position].actorEntityList!!.isNotEmpty()) {
            //holder.singerName?.text = listFilmDetail[position].actorEntityList?.get(position)?.actorname
        }
    }

    inner class ViewHolder(item: View, private val itemClick: (FilmEntityModel) -> Unit) :
        RecyclerView.ViewHolder(item) {
        var imgItemFilm: ImageView? = itemView?.findViewById(R.id.imageFilmDetail)
        var filmNames: TextView? = itemView?.findViewById(R.id.filmNames)
        var singerName: TextView? = itemView?.findViewById(R.id.singerName)
        var luotxem: TextView? = itemView?.findViewById(R.id.luotxem)

        init {
            itemView?.setOnClickListener {
                itemClick?.invoke(listFilmDetail[adapterPosition])
            }
        }
    }
}