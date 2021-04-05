package com.itsm.dto

import com.itsm.domain.Item
import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotEmpty

@Introspected
class ItemDTO {
    @NotEmpty(message = "Name may not be empty")
    var name = ""
}

fun ItemDTO.toDomain(): Item = Item(name = this.name)