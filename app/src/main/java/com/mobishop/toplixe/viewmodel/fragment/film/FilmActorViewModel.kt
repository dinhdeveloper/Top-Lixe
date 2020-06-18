package com.mobishop.toplixe.viewmodel.fragment.film

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobishop.toplixe.model.actor.ActorEntityModel
import com.mobishop.toplixe.model.film.FilmEntityModel
import com.mobishop.toplixe.repositories.fragment.film.FilmActorRepository
import com.mobishop.toplixe.repositories.fragment.film.FilmHotRepository

class FilmActorViewModel :ViewModel() {
    private var data: MutableLiveData<List<ActorEntityModel>> = MutableLiveData()
    private val repository: FilmActorRepository = FilmActorRepository()

    //truyền data sang cho activity
    fun getData(): MutableLiveData<List<ActorEntityModel>>? {
        //gán data lấy từ api về cho data trong viewmodel
        data = repository.dataApi()
        return data
    }
}