package com.itsm.dto

import com.itsm.domain.EventBuilder
import io.micronaut.core.annotation.Introspected
import java.util.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull


@Introspected
class EventBuilderDTO {
    @NotNull(message = "Item may not be null")
    lateinit var item: ItemDTO

    @NotNull(message = "Category may not be null")
    lateinit var category :CategoryDTO
}

fun EventBuilderDTO.toDomain(): EventBuilder = EventBuilder(item = this.item.id, category = this.category.id)