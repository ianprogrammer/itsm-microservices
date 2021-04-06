package com.itsm.controller

import com.itsm.domain.Category
import com.itsm.dto.CategoryDTO
import com.itsm.repository.contracts.CategoryRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.scheduling.TaskExecutors
import io.micronaut.scheduling.annotation.ExecuteOn
import io.micronaut.validation.Validated
import java.util.*
import javax.inject.Inject
import javax.validation.Valid

@ExecuteOn(TaskExecutors.IO)
@Controller("/category")
@Validated
class CategoryController (
    @Inject
    private val itemRepository: CategoryRepository) {

    @Get("/{id}")
    fun show(id: UUID): HttpResponse<Category> {
        return HttpResponse.ok(
            itemRepository
                .findById(id).orElse(null)
        )
    }

    @Put("/{id}")
    fun update(@Body @Valid data: CategoryDTO, id: UUID): HttpResponse<*> {
        val numberOfEntitiesUpdated: Int = itemRepository.update(id, data)
        return HttpResponse
            .noContent<Any>()
    }

    @Post
    fun save(@Body @Valid data: CategoryDTO): HttpResponse<Category> {
        val item = itemRepository.save(data)
        return HttpResponse.created(item)
    }

    @Delete("/{id}")
    fun delete(id: UUID): HttpResponse<*>? {
        itemRepository.deleteById(id)
        return HttpResponse.noContent<Any>()
    }
}