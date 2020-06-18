package com.mobishop.toplixe.model.song

import java.io.Serializable

data class SingerEntity(
    val active: Boolean,
    val id: Int,
    val img: String,
    val info: String,
    val singername: String
):Serializable