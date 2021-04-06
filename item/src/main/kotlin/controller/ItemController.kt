package com.itsm.controller

import com.itsm.domain.Item
import com.itsm.dto.ItemDTO
import com.itsm.repository.contracts.ItemRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.scheduling.TaskExecutors
import io.micronaut.scheduling.annotation.ExecuteOn
import io.micronaut.validation.Validated
import java.util.*
import javax.inject.Inject
import javax.validation.Valid

@ExecuteOn(TaskExecutors.IO)
@Controller("/item")
@Validated
class ItemController (
    @Inject
    private val itemRepository: ItemRepository) {

    @Get("/{id}")
    fun show(id: UUID): HttpResponse<Item> {
        return HttpResponse.ok(
            itemRepository
                .findById(id).orElse(null)
        )
    }

    @Put("/{id}")
    fun update(@Body @Valid data: ItemDTO, id: UUID): HttpResponse<*> {
        val numberOfEntitiesUpdated: Int = itemRepository.update(id, data)
        return HttpResponse
            .noContent<Any>()
    }

    @Post
    fun save(@Body @Valid data: ItemDTO): HttpResponse<Item> {
        val item = itemRepository.save(data)
        return HttpResponse.created(item)
    }

    @Delete("/{id}")
    fun delete(id: UUID): HttpResponse<*>? {
        itemRepository.deleteById(id)
        return HttpResponse.noContent<Any>()
    }
}