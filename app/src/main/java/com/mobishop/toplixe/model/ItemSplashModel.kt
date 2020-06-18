package com.mobishop.toplixe.model

class ItemSplashModel {
    private var image = 0
    private var title: String? = ""
    private var description: String? = ""

    fun getImage(): Int {
        return image
    }

    fun setImage(image: Int) {
        this.image = image
    }

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String?) {
        this.title = title
    }

    fun getDescription(): String? {
        return description
    }

    fun setDescription(description: String?) {
        this.description = description
    }
}