package com.mobishop.toplixe.repositories.activity

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mobishop.toplixe.api.APIService
import com.mobishop.toplixe.api.APIUntil
import com.mobishop.toplixe.model.film.FilmEntityModel
import retrofit2.Call
import retrofit2.Response

class ListFilmMoreRepository {
    private var apiService: APIService? = null
    fun dataApi(): MutableLiveData<List<FilmEntityModel>> {
        val data: MutableLiveData<List<FilmEntityModel>> = MutableLiveData<List<FilmEntityModel>>()
        apiService = APIUntil.server
        apiService!!.getHasPageFilm(20,0).enqueue(object : retrofit2.Callback<List<FilmEntityModel>> {
            override fun onFailure(call: Call<List<FilmEntityModel>>, t: Throwable) {
                Log.e("onFailure", "${t.message}")
            }

            override fun onResponse(
                call: Call<List<FilmEntityModel>>,
                response: Response<List<FilmEntityModel>>
            ) {
                if (response.isSuccessful) {
                    data.postValue(response.body())
                }
            }

        })
        return data
    }
}