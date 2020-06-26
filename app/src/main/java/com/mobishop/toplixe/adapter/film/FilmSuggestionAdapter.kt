package com.mobishop.toplixe.adapter.film

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mobishop.toplixe.R
import com.mobishop.toplixe.common.CountTime
import com.mobishop.toplixe.model.film.FilmEntityModel

class FilmSuggestionAdapter(
    private val context: Context?,
    private val listFilm: List<FilmEntityModel>,
    private val itemClick: (FilmEntityModel) -> Unit
) : RecyclerView.Adapter<FilmSuggestionAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view =
            LayoutInflater.from(context).inflate(R.layout.custom_film_suggestion, parent, false)
        return ViewHolder(view,itemClick)
    }

    override fun getItemCount(): Int {
        return if (listFilm.size > 4) {
            4
        } else {
            listFilm.size
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (context != null) {
            Glide.with(context).load(listFilm[position].filmEntity?.img).error(R.drawable.empty)
                .into(holder.imgItemFilm!!)
            holder.txtNameFilm?.text = listFilm[position].filmEntity?.filmname
            var countTime : CountTime = CountTime()
            holder.time?.text = countTime.countTime(listFilm[position].filmEntity?.length!!.toDouble())
        }
    }

    inner class ViewHolder(
        item: View,
        private val itemClick: (FilmEntityModel) -> Unit
    ) : RecyclerView.ViewHolder(item) {
        var imgItemFilm: ImageView? = itemView?.findViewById(R.id.imgItemFilm)
        var txtNameFilm: TextView? = itemView?.findViewById(R.id.txtNameFilm)
        var time: TextView? = itemView?.findViewById(R.id.time)
        init {
            itemView?.setOnClickListener {
                itemClick?.invoke(listFilm[adapterPosition])
            }
        }
    }
}