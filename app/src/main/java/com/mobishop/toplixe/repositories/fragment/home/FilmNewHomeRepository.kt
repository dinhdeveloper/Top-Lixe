package com.mobishop.toplixe.repositories.fragment.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mobishop.toplixe.api.APIService
import com.mobishop.toplixe.api.APIUntil
import com.mobishop.toplixe.model.film.FilmEntityModel

import retrofit2.Call
import retrofit2.Response

class FilmNewHomeRepository {
    private var apiInterfaceInterface: APIService? = null

    fun dataAPI(): MutableLiveData<List<FilmEntityModel>> {
        val data: MutableLiveData<List<FilmEntityModel>> = MutableLiveData<List<FilmEntityModel>>()
        apiInterfaceInterface = APIUntil.server
        apiInterfaceInterface!!.getAllFilm()
            .enqueue(object : retrofit2.Callback<List<FilmEntityModel>> {
                override fun onFailure(call: Call<List<FilmEntityModel>>, t: Throwable) {
                    Log.e("onFailure", t.message)
                }

                override fun onResponse(
                    call: Call<List<FilmEntityModel>>,
                    response: Response<List<FilmEntityModel>>
                ) {
                    if (response.isSuccessful){
                        data.postValue(response.body())
                    }
                }

            })
        return data
    }
}