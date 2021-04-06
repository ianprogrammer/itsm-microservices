package com.itsm.dto

import com.itsm.domain.Category
import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotEmpty

@Introspected
class CategoryDTO {
    @NotEmpty(message = "Name may not be empty")
    var name = ""
}

fun CategoryDTO.toDomain(): Category = Category(name = this.name)