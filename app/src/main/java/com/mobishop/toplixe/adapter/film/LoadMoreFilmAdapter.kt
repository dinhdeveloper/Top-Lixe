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

class LoadMoreFilmAdapter (
    private val context: Context?,
    private val filmList: List<FilmEntityModel>,
    private val itemClick: (FilmEntityModel) -> Unit
) : RecyclerView.Adapter<LoadMoreFilmAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view =
            LayoutInflater.from(context).inflate(R.layout.custom_film_has_page, parent, false)
        return ViewHolder(view,itemClick)
    }

    override fun getItemCount(): Int {
        return filmList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (context != null) {
            Glide.with(context).load(filmList[position].filmEntity?.img).error(R.drawable.empty)
                .into(holder.imageFilm!!)
            holder.txtName?.text = filmList[position].filmEntity?.filmname
            holder.textDes?.text = filmList[position].filmEntity?.info
            holder.textView?.text = "1249 lượt xem"
            var countTime : CountTime = CountTime()
            holder.time?.text = countTime.countTime(filmList[position].filmEntity?.length!!.toDouble())
        }
    }

    inner class ViewHolder(
        item: View,
        private val itemClick: (FilmEntityModel) -> Unit
    ) : RecyclerView.ViewHolder(item) {
        var imageFilm: ImageView? = itemView?.findViewById(R.id.imageFilm)
        var txtName: TextView? = itemView?.findViewById(R.id.txtName)
        var textDes: TextView? = itemView?.findViewById(R.id.textDes)
        var textView: TextView? = itemView?.findViewById(R.id.view)
        var time: TextView? = itemView?.findViewById(R.id.time)
        init {
            itemView?.setOnClickListener {
                itemClick?.invoke(filmList[adapterPosition])
            }
        }
    }
}