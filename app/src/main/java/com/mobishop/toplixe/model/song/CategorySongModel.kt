package com.mobishop.toplixe.model.song

data class CategorySongModel(
    var categorysongEntity: CategorysongEntity?,
    var songDTOList: List<SongDTO?>?
) {
    data class CategorysongEntity(
        var categoryname: String?,
        var id: Int?,
        var range: Int?
    )

    data class SongDTO(
        var albumEntity: AlbumEntity?,
        var authorEntity: AuthorEntity?,
        var categorySongEntityList: List<CategorySongEntity?>?,
        var imageEntity: ImageEntity?,
        var singerEntityList: List<SingerEntity?>?,
        var songEntity: SongEntity?,
        var uploadEntityList: List<Any?>?
    ) {
        data class AlbumEntity(
            var albumname: String?,
            var datereleased: Long?,
            var id: Int?,
            var index: Int?,
            var range: Int?,
            var singerid: Int?
        )

        data class AuthorEntity(
            var id: Int?,
            var info: String?,
            var name: String?
        )

        data class CategorySongEntity(
            var categoryname: String?,
            var id: Int?,
            var range: Int?
        )

        data class ImageEntity(
            var entryid: Int?,
            var fileextension: Any?,
            var id: Int?,
            var model: Any?,
            var path: Any?,
            var size: Any?
        )

        data class SingerEntity(
            var active: Boolean?,
            var id: Int?,
            var img: String?,
            var info: String?,
            var singername: String?
        )

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
        )
    }
}