package com.mobishop.toplixe.adapter.singer

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mobishop.toplixe.R
import com.mobishop.toplixe.common.CountTime
import com.mobishop.toplixe.model.song.SingerEntityModel

class LoadSongOfSingerAdapter(
    private val context: Context?,
    private val listFilm: List<SingerEntityModel.SongDTO>,
    private val itemClick: (SingerEntityModel.SongDTO) -> Unit
) : RecyclerView.Adapter<LoadSongOfSingerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view =
            LayoutInflater.from(context).inflate(R.layout.custom_item_singer, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return listFilm.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        try {
            context?.let {
                Glide.with(it).load(listFilm[position]?.songEntity?.img).error(R.drawable.empty)
                    .into(holder.imgItemFilm !!)
            }
            holder.txtNameFilm?.text = listFilm[position]?.songEntity?.songname
        } catch (e: Exception) {
            Log.e("Err", e.toString())
        }
    }

    inner class ViewHolder(
        item: View,
        private val itemClick: (SingerEntityModel.SongDTO) -> Unit
    ) : RecyclerView.ViewHolder(item) {
        var imgItemFilm: ImageView? = itemView?.findViewById(R.id.imgItem)
        var txtNameFilm: TextView? = itemView?.findViewById(R.id.txtAd)
        var time: TextView? = itemView?.findViewById(R.id.txt)

        init {
            itemView?.setOnClickListener {
                itemClick?.invoke(listFilm[adapterPosition])
            }
        }
    }
}