package com.mobishop.toplixe.repositories.fragment.film

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mobishop.toplixe.api.APIService
import com.mobishop.toplixe.api.APIUntil
import com.mobishop.toplixe.model.actor.ActorEntityModel
import com.mobishop.toplixe.model.film.FilmEntityModel
import retrofit2.Call
import retrofit2.Response

class FilmActorRepository {
    private var apiService: APIService? = null
    fun dataApi(): MutableLiveData<List<ActorEntityModel>> {
        val data: MutableLiveData<List<ActorEntityModel>> = MutableLiveData<List<ActorEntityModel>>()
        apiService = APIUntil.server
        apiService!!.getActor(5,0).enqueue(object : retrofit2.Callback<List<ActorEntityModel>> {
            override fun onFailure(call: Call<List<ActorEntityModel>>, t: Throwable) {
                Log.e("onFailure", "${t.message}")
            }

            override fun onResponse(
                call: Call<List<ActorEntityModel>>,
                response: Response<List<ActorEntityModel>>
            ) {
                if (response.isSuccessful) {
                    data.postValue(response.body())
                }
            }

        })
        return data
    }
}