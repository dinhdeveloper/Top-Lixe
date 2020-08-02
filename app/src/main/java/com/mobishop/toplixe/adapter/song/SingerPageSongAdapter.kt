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
import com.mobishop.toplixe.model.song.SingerEntity
import com.mobishop.toplixe.model.song.SingerEntityModel
import de.hdodenhof.circleimageview.CircleImageView

class SingerPageSongAdapter (
    private val context: Context?,
    private val songList: List<SingerEntityModel>,
    private val itemClick: (SingerEntityModel) -> Unit
) : RecyclerView.Adapter<SingerPageSongAdapter.ViewHolder>() {
    inner class ViewHolder(
        itemView: View,
        private val itemClick: (SingerEntityModel) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        var imgItem: CircleImageView? = itemView?.findViewById(R.id.imgItem)
        var txtName: TextView? = itemView?.findViewById(R.id.txtName)

        init {
            itemView?.setOnClickListener {
                itemClick?.invoke(songList[adapterPosition])
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view =
            LayoutInflater.from(context).inflate(R.layout.custom_singer_page, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return songList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (context != null) {
            Glide.with(context).load(songList[position].singerEntity!!.img)
                .into(holder.imgItem!!)
            holder.txtName?.text = songList[position].singerEntity?.singername
        }
    }
}