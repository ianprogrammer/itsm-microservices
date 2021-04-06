package com.itsm.domain


import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotNull


@Introspected
data class EventBuilder (
    @NotNull(message = "Item may not be null")
     val item : Item,
    @NotNull(message = "Category may not be null")
    val category : Category
)


