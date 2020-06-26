package com.mobishop.toplixe.model.album

import java.io.Serializable

data class AlbumEntityModel(
    var albumEntity: AlbumEntity?,
    var singerEntity: List<SingerEntity?>?,
    var songDTOList: List<SongDTO?>?
):Serializable {
    data class AlbumEntity(
        var albumname: String?,
        var datereleased: Long?,
        var id: Int?,
        var index: Int?,
        var range: Int?,
        var singerid: Int?
    ):Serializable

    data class SingerEntity(
        var active: Boolean?,
        var id: Int?,
        var img: String?,
        var info: String?,
        var singername: String?
    ):Serializable

    data class SongDTO(
        var active: Boolean?,
        var authorid: Int?,
        var createdate: Long?,
        var id: Int?,
        var img: String?,
        var modifieddate: Long?,
        var modifieduser: String?,
        var range: Int?,
        var songname: String?,
        var uploadsource: String?
    ):Serializable
}