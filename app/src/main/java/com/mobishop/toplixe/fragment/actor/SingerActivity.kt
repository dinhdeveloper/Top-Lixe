package com.mobishop.toplixe.fragment.actor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.mobishop.toplixe.R
import com.mobishop.toplixe.activity.SongDetailActivity
import com.mobishop.toplixe.adapter.singer.LoadSongOfSingerAdapter
import com.mobishop.toplixe.model.song.SingerEntityModel
import kotlinx.android.synthetic.main.activity_actor.actorName
import kotlinx.android.synthetic.main.activity_actor.imageActor
import kotlinx.android.synthetic.main.activity_singer.*

class SingerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singer)

        val people = intent.getSerializableExtra("Singer") as? SingerEntityModel

        var list: List<SingerEntityModel.SongDTO> =
            (people?.songDTOList) as List<SingerEntityModel.SongDTO>

        if (people != null) {
            Glide.with(applicationContext).load(people?.singerEntity?.img).into(imageActor)
            actorName.text = people?.singerEntity?.singername
            actorSize.text = "Ca sĩ ${people?.singerEntity?.singername + " có " + list.size+" bài hát."}"
            rc_singer.layoutManager = GridLayoutManager(applicationContext, 3)

            var filmSuggestionAdapter =
                LoadSongOfSingerAdapter(applicationContext, list, itemClick = {
                    val intent =
                        Intent(this, SongDetailActivity::class.java)
                    intent.putExtra("DETAIL",it)
                    startActivity(intent)
                })
            rc_singer.adapter = filmSuggestionAdapter
//        }
        }
    }
}