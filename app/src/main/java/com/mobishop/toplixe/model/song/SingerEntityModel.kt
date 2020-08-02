package com.mobishop.toplixe.model.song

import java.io.Serializable

data class SingerEntityModel(
    var singerEntity: SingerEntity?,
    var songDTOList: List<SongDTO?>?
): Serializable {
    data class SingerEntity(
        var active: Boolean?,
        var id: Int?,
        var img: String?,
        var info: String?,
        var singername: String?
    ): Serializable

    data class SongDTO(
        var albumEntity: AlbumEntity?,
        var authorEntity: AuthorEntity?,
        var categorySongEntityList: List<CategorySongEntity?>?,
        var imageEntity: ImageEntity?,
        var singerEntityList: List<SingerEntity?>?,
        var songEntity: SongEntity?,
        var uploadEntityList: List<Any?>?
    ) : Serializable {
        data class AlbumEntity(
            var albumname: String?,
            var datereleased: Long?,
            var id: Int?,
            var index: Int?,
            var range: Int?,
            var singerid: Int?
        ): Serializable

        data class AuthorEntity(
            var id: Int?,
            var info: String?,
            var name: String?
        ): Serializable

        data class CategorySongEntity(
            var categoryname: String?,
            var id: Int?,
            var range: Int?
        ): Serializable

        data class ImageEntity(
            var entryid: Int?,
            var fileextension: Any?,
            var id: Int?,
            var model: Any?,
            var path: Any?,
            var size: Any?
        ): Serializable

        data class SingerEntity(
            var active: Boolean?,
            var id: Int?,
            var img: String?,
            var info: String?,
            var singername: String?
        ): Serializable

        data class SongEntity(
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
        ): Serializable
    }
}