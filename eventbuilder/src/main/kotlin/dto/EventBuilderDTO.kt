package com.itsm.dto

import com.itsm.domain.Category
import com.itsm.domain.Item
import io.micronaut.core.annotation.Introspected
import java.util.*
import javax.validation.constraints.NotNull


@Introspected
class EventBuilderDTO {
    @NotNull(message = "Item may not be null")
    lateinit var item : UUID
    @NotNull(message = "Category may not be null")
    lateinit var category : UUID
}