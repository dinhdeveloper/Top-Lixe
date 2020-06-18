package com.mobishop.toplixe.model.song

import Song
import java.io.Serializable

data class SongEntityModel(
    val albumEntity: Any,
    val authorEntity: AuthorEntity,
    val categorySongEntityList: List<Any>,
    val imageEntity: ImageEntity,
    val singerEntityList: List<SingerEntity>,
    val songEntity: Song,
    val uploadEntityList: List<Any>
):Serializable