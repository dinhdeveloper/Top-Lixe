package com.mobishop.toplixe.fragment.song

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobishop.toplixe.R
import com.mobishop.toplixe.model.song.SongEntityModel
import kotlinx.android.synthetic.main.fragment_item_song.*

class ItemSongFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View =
            LayoutInflater.from(activity).inflate(R.layout.fragment_item_song, container, false)

        getIntents()

        return view
    }

    private fun getIntents() {

//        var intent = activity !!.intent
//        var songEntityModel: SongEntityModel =
//            intent.getSerializableExtra("model") as SongEntityModel
//        layout_song.visibility = View.VISIBLE
    }

}