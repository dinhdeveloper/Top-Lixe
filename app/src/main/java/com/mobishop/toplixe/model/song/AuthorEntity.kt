package com.mobishop.toplixe.model.song

import java.io.Serializable

data class AuthorEntity(
    val id: Int,
    val info: String,
    val name: String
): Serializable