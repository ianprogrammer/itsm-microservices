package com.itsm.domain


import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity(name = "item_table")
data class Item(
    @Id
    @GeneratedValue
    val id: UUID? = null,
    @NotNull
    @Column(name = "name", nullable = false, unique = true)
    val name: String,
)

