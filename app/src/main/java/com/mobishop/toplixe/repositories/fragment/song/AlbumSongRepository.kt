package com.mobishop.toplixe.repositories.fragment.song

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mobishop.toplixe.api.APIService
import com.mobishop.toplixe.api.APIUntil
import com.mobishop.toplixe.model.album.AlbumEntityModel
import com.mobishop.toplixe.model.song.SongEntityModel
import retrofit2.Call
import retrofit2.Response

class AlbumSongRepository {
    private var apiService: APIService? = null

    fun dataAPI(): MutableLiveData<List<AlbumEntityModel>> {
        val data: MutableLiveData<List<AlbumEntityModel>> = MutableLiveData<List<AlbumEntityModel>>()
        apiService = APIUntil.server
        apiService!!.getAllAlbum()
            .enqueue(object : retrofit2.Callback<List<AlbumEntityModel>> {
                override fun onFailure(call: Call<List<AlbumEntityModel>>, t: Throwable) {
                    Log.e("onFailure", t.message)
                }

                override fun onResponse(
                    call: Call<List<AlbumEntityModel>>,
                    response: Response<List<AlbumEntityModel>>
                ) {
                    if (response.isSuccessful){
                        data.postValue(response.body())
                    }
                }

            })
        return data
    }
}