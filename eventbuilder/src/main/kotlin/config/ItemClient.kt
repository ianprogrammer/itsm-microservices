package com.itsm.config

import com.itsm.domain.Item
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.reactivex.Single


@Client(id="item")
interface ItemClient {

    @Get("/item/{id}")
    fun get(id: String): Single<Item>
}