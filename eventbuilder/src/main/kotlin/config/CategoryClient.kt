package com.itsm.config

import com.itsm.domain.Category
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import io.reactivex.Single


@Client(id="category")
interface CategoryClient {

    @Get("/category/{id}")
    fun get(id: String): Single<Category>
}