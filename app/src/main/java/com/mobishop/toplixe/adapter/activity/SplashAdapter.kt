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
import com.mobishop.toplixe.model.ItemSplashModel

class SplashAdapter(
    private val context: Context?,
    private var list: List<ItemSplashModel>
) : RecyclerView.Adapter<SplashAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view: View =
            LayoutInflater.from(context).inflate(R.layout.item_layout_splash, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        context?.let { Glide.with(it).load(list[position].getImage()).into(holder.imageSplash) }
        holder.textTitle.text = list[position].getTitle()
        holder.textDescription.text = list[position].getDescription()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageSplash: ImageView = view.findViewById(R.id.imageSplash)
        var textTitle: TextView = view.findViewById(R.id.textTitle)
        var textDescription: TextView = view.findViewById(R.id.textDes)
    }

}