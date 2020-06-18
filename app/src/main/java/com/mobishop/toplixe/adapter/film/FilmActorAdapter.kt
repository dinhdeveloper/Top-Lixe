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
import com.mobishop.toplixe.model.actor.ActorEntityModel
import com.mobishop.toplixe.model.film.FilmEntityModel

class FilmActorAdapter(
    private val context: Context?,
    private val actorList: List<ActorEntityModel>,
    private val itemClick: (ActorEntityModel) -> Unit
) : RecyclerView.Adapter<FilmActorAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view =
            LayoutInflater.from(context).inflate(R.layout.custom_item_actor_film, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return actorList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (context != null) {
            Glide.with(context).load(actorList[position].imageEntity?.path)
                .into(holder.imgItem!!)
            holder.txtAd?.text = actorList[position].actorEntity?.actorname
//            holder.txt?.text = actorList[position].filmDTOList?.get(position)?.filmEntity?.filmname
        }
    }

    inner class ViewHolder(
        item: View,
        private val itemClick: (ActorEntityModel) -> Unit
    ) : RecyclerView.ViewHolder(item) {
        var imgItem: ImageView? = itemView?.findViewById(R.id.imgItem)
        var favorite: ImageView? = itemView?.findViewById(R.id.favorite)
        var txtAd: TextView? = itemView?.findViewById(R.id.txtAd)
        var txt: TextView? = itemView?.findViewById(R.id.txt)

        init {
            itemView?.setOnClickListener {
                itemClick?.invoke(actorList[adapterPosition])
            }
//            itemView.favorite.setOnClickListener {
//                if (CHECK_FAVORITE){
//                    favorite?.setImageResource(R.drawable.ic_favorite_white_24dp)
//                    CHECK_FAVORITE = false
//                }
//                else{
//                    favorite?.setImageResource(R.drawable.ic_unfavorite_white_24dp)
//                    CHECK_FAVORITE = true
//                }
//            }
        }
    }
}