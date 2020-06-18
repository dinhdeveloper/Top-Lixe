package com.mobishop.toplixe.model.film

import java.io.Serializable

data class FilmEntityModel(
    var actorEntityList: List<ActorEntity?>?,
    var categoryFilmEntityList: List<Any?>?,
    var directorEntity: DirectorEntity?,
    var filmEntity: FilmEntity?,
    var imageEntity: List<Any?>?,
    var seriCategoryFilmEntity: Any?,
    var uploadEntityList: List<Any?>?
):Serializable {
    data class ActorEntity(
        var actorname: String?,
        var ext: String?,
        var id: Int?
    ):Serializable

    data class DirectorEntity(
        var ext: String?,
        var id: Int?,
        var name: String?
    ):Serializable

    data class FilmEntity(
        var active: Boolean?,
        var actorid: Int?,
        var country: String?,
        var createdate: Any?,
        var directorid: Int?,
        var filmname: String?,
        var id: Int?,
        var img: String?,
        var index: Int?,
        var info: String?,
        var length: Int?,
        var range: Int?,
        var uploadsource: String?,
        var yearreleased: Int?
    ):Serializable
}