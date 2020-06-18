package com.mobishop.toplixe.api

import com.mobishop.toplixe.api.APIClient.getApiClient


object APIUntil {
    private const val baseURL =
        "http://115.73.214.162:7777/" // https://mobishops.herokuapp.com/ http://vtnshop.herokuapp.com/

    val server: APIService
        get() = getApiClient(baseURL)?.create(APIService::class.java)!!

}