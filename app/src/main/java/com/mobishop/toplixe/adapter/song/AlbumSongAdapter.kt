package com.mobishop.toplixe.adapter.song

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mobishop.toplixe.R
import com.mobishop.toplixe.model.album.AlbumEntityModel
import com.mobishop.toplixe.model.song.SongEntityModel

class AlbumSongAdapter(
    private val context: Context?,
    private val songList: List<AlbumEntityModel>,
    private val itemClick: (AlbumEntityModel) -> Unit
) : RecyclerView.Adapter<AlbumSongAdapter.ViewHolder>() {
    inner class ViewHolder(
        itemView: View,
        private val itemClick: (AlbumEntityModel) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        var imageSong: ImageView? = itemView?.findViewById(R.id.imageSong)
        var nameSong: TextView? = itemView?.findViewById(R.id.nameSong)
        var singerName: TextView? = itemView?.findViewById(R.id.singerName)

        init {
            itemView?.setOnClickListener {
                itemClick?.invoke(songList[adapterPosition])
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view =
            LayoutInflater.from(context).inflate(R.layout.custom_item_music, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return songList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (context != null) {
            Glide.with(context).load(R.drawable.bontram)
                .into(holder.imageSong!!)
            holder.nameSong?.text = songList[position].albumEntity?.albumname
            holder.singerName?.text = "Phan Manh Quynh"
//            if (songList[position].singerEntityList.isNotEmpty()) {
//                holder.txtMore?.text = songList[position].singerEntityList[position].singername
//            }
//            if (songList[position].singerEntityList.isEmpty()) {
//                holder.txtMore?.text = null
//            }
        }
    }
}