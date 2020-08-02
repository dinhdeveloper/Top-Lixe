package com.mobishop.toplixe.api

import com.mobishop.toplixe.model.actor.ActorEntityModel
import com.mobishop.toplixe.model.album.AlbumEntityModel
import com.mobishop.toplixe.model.film.FilmEntityModel
import com.mobishop.toplixe.model.song.CategorySongModel
import com.mobishop.toplixe.model.song.SingerEntity
import com.mobishop.toplixe.model.song.SingerEntityModel
import com.mobishop.toplixe.model.song.SongEntityModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface APIService {
//    @get:GET("category/list")
//    val allCategory: Call<List<Category>>
//
//    @GET("uis")
//    fun getUser(@Query("id") id: String): Call<Account>

    //    @GET("product/cate=")
//    fun getProductcById(@Query("id") id: Int): Call<List<Product>>
    //    @POST("product/list"z
    //    Call<ArrayList<Product>> getProductLists(@Body PagingProduct pagingProduct);
//    @GET("product/cate={id}")
//    fun getProductById(@Path("id") id: Int): Call<ArrayList<Product>>
    public companion object {
        const val API_TOKEN = "7E277A25310E4D1AA3E6B0F0615AD39A";
    }

    @GET("Lixe/api/MusicSite/Song/GetTop10/")
    fun getAllSong(): Call<List<SongEntityModel>>

    @GET("Lixe/api/FilmSite/Film/GetTop10/")
    fun getAllFilm(): Call<List<FilmEntityModel>>

    @GET("Lixe/api/FilmSite/Film/GetRandom10/")
    fun getFilmRandom(): Call<List<FilmEntityModel>>

    @GET("Lixe/api/FilmSite/Film/GetAllHasPage{itemOnPage}/{page}")
    fun getHasPageFilm(
        @Path("itemOnPage") itemOnPage: Int,
        @Path("page") page: Int
    ): Call<List<FilmEntityModel>>


    @GET("Lixe/api/MusicSite/Song/GetRandom10/")
    fun getSongRandom(): Call<List<SongEntityModel>>

    @GET("Lixe/api/MusicSite/Song/GetAllHasPage{itemOnPage}/{page}")
    fun getSongPage(
        @Path("itemOnPage") itemOnPage: Int,
        @Path("page") page: Int
    ): Call<List<SongEntityModel>>


    @GET("Lixe/api/FilmSite/Actor/GetAllHasPage{itemOnPage}/{page}")
    fun getActor(
        @Path("itemOnPage") itemOnPage: Int,
        @Path("page") page: Int
    ): Call<List<ActorEntityModel>>

    @GET("Lixe/api/FilmSite/Actor/GetDetail/{id}")
    fun getActorDetail(
        @Path("id") itemOnPage: Int
    ): Call<ActorEntityModel>

    @GET("/Lixe/api/MusicSite/Singer/GetAllHasPage{itemOnPage}/{page}")
    fun getSingerPage(
        @Path("itemOnPage") itemOnPage: Int,
        @Path("page") page: Int
    ): Call<List<SingerEntityModel>>

    @GET("Lixe/api/MusicSite/Category/GetAllHasPage{itemOnPage}/{page}")
    fun getCategorySong(
        @Path("itemOnPage") itemOnPage: Int,
        @Path("page") page: Int
    ): Call<List<CategorySongModel>>


    @GET("Lixe/api/MusicSite/Album/GetTop10")
    fun getAllAlbum(): Call<List<AlbumEntityModel>>

//
//    @GET("Lixe/api/FilmSite/Film/GetAllHasPage{itemOnPage}/{page}")
//    fun getHasPage(
//        @Path("itemOnPage") itemOnPage: Int,
//        @Path("page") page: Int
//    ): Call<List<FilmEntity>>
//
//    @GET("Lixe/api/MusicSite/Album/GetTop10")
//    fun getAllAlbum(): Call<List<Album>>
//
//    @GET("Lixe/api/MusicSite/Song/GetDetail/{id}")
//    fun getSongDetail(@Path("id") id: Int):Call<SongEntity>
}