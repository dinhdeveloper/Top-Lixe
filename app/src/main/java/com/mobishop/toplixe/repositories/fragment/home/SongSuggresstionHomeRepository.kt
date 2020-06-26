package com.mobishop.toplixe.repositories.fragment.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mobishop.toplixe.api.APIService
import com.mobishop.toplixe.api.APIUntil
import com.mobishop.toplixe.model.song.SongEntityModel
import retrofit2.Call
import retrofit2.Response

class SongSuggresstionHomeRepository {

    private var apiInterfaceInterface: APIService? = null

    fun dataAPI(): MutableLiveData<List<SongEntityModel>> {
        val data: MutableLiveData<List<SongEntityModel>> = MutableLiveData<List<SongEntityModel>>()
        apiInterfaceInterface = APIUntil.server
        apiInterfaceInterface!!.getSongRandom()
            .enqueue(object : retrofit2.Callback<List<SongEntityModel>> {
                override fun onFailure(call: Call<List<SongEntityModel>>, t: Throwable) {
                    Log.e("onFailure", t.message)
                }

                override fun onResponse(
                    call: Call<List<SongEntityModel>>,
                    response: Response<List<SongEntityModel>>
                ) {
                    if (response.isSuccessful){
                        data.postValue(response.body())
                    }
                }

            })
        return data
    }

}