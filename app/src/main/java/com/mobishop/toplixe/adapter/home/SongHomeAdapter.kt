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
import com.mobishop.toplixe.model.song.SongEntityModel

class SongHomeAdapter(
    private val context: Context?,
    private val songList: List<SongEntityModel>,
    private val itemClick: (SongEntityModel) -> Unit
) : RecyclerView.Adapter<SongHomeAdapter.ViewHolder>() {
    inner class ViewHolder(
        itemView: View,
        private val itemClick: (SongEntityModel) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        var imageSong: ImageView? = itemView?.findViewById(R.id.imageSong)
        var nameSong: TextView? = itemView?.findViewById(R.id.nameSong)
        var txtMore: TextView? = itemView?.findViewById(R.id.txtMore)

        init {
            itemView?.setOnClickListener {
                itemClick?.invoke(songList[adapterPosition])
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view =
            LayoutInflater.from(context).inflate(R.layout.custom_item_song_home, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return if (songList.size != null) {
            6
        } else {
            0
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (context != null) {
            Glide.with(context).load(songList[position].songEntity?.img)
                .into(holder.imageSong!!)
            holder.nameSong?.text = songList[position].songEntity.songname
//            if (songList[position].singerEntityList.isNotEmpty()) {
//                holder.txtMore?.text = songList[position].singerEntityList[position].singername
//            }
//            if (songList[position].singerEntityList.isEmpty()) {
//                holder.txtMore?.text = null
//            }
        }
    }
}