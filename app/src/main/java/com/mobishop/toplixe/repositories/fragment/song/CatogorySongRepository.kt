package com.mobishop.toplixe.repositories.fragment.song

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mobishop.toplixe.api.APIService
import com.mobishop.toplixe.api.APIUntil
import com.mobishop.toplixe.model.song.CategorySongModel
import com.mobishop.toplixe.model.song.SingerEntityModel
import retrofit2.Call
import retrofit2.Response

class CatogorySongRepository {
    private var apiService: APIService? = null

    fun dataAPI(): MutableLiveData<List<CategorySongModel>> {
        val data: MutableLiveData<List<CategorySongModel>> = MutableLiveData<List<CategorySongModel>>()
        apiService = APIUntil.server
        apiService!!.getCategorySong(100,0)
            .enqueue(object : retrofit2.Callback<List<CategorySongModel>> {
                override fun onFailure(call: Call<List<CategorySongModel>>, t: Throwable) {
                    Log.e("onFailure", t.message)
                }

                override fun onResponse(
                    call: Call<List<CategorySongModel>>,
                    response: Response<List<CategorySongModel>>
                ) {

                    if (response.isSuccessful){
                        data.postValue(response.body())
                    }
                }

            })
        return data
    }
}