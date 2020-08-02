package com.mobishop.toplixe.repositories.fragment.song

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mobishop.toplixe.api.APIService
import com.mobishop.toplixe.api.APIUntil
import com.mobishop.toplixe.model.song.SingerEntity
import com.mobishop.toplixe.model.song.SingerEntityModel
import retrofit2.Call
import retrofit2.Response

class SingerPageSongRepository {
    private var apiService: APIService? = null

    fun dataAPI(): MutableLiveData<List<SingerEntityModel>> {
        val data: MutableLiveData<List<SingerEntityModel>> = MutableLiveData<List<SingerEntityModel>>()
        apiService = APIUntil.server
        apiService!!.getSingerPage(10,0)
            .enqueue(object : retrofit2.Callback<List<SingerEntityModel>> {
                override fun onFailure(call: Call<List<SingerEntityModel>>, t: Throwable) {
                    Log.e("onFailure", t.message)
                }

                override fun onResponse(
                    call: Call<List<SingerEntityModel>>,
                    response: Response<List<SingerEntityModel>>
                ) {

                    if (response.isSuccessful){
                        data.postValue(response.body())
                    }
                }

            })
        return data
    }
}