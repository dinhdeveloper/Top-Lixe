package com.mobishop.toplixe.fragment.actor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.mobishop.toplixe.R
import com.mobishop.toplixe.adapter.film.FilmSuggestionAdapter
import com.mobishop.toplixe.adapter.film.LoadFilmOfActorAdapter
import com.mobishop.toplixe.model.actor.ActorEntityModel
import com.mobishop.toplixe.model.film.FilmEntityModel
import kotlinx.android.synthetic.main.activity_actor.*

class ActorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actor)

        val people = intent.getSerializableExtra("Actor") as? ActorEntityModel

        var list: List<ActorEntityModel.FilmDTO> =
            (people?.filmDTOList) as List<ActorEntityModel.FilmDTO>

        if (people != null) {
            Glide.with(applicationContext).load(people?.imageEntity?.path).into(imageActor)
            actorName.text = people?.actorEntity?.actorname

            rc_film_actor.layoutManager = GridLayoutManager(applicationContext, 2)

            var filmSuggestionAdapter =
                LoadFilmOfActorAdapter(applicationContext, list, itemClick = {

                })
            rc_film_actor.adapter = filmSuggestionAdapter
//        }
        }
    }
}