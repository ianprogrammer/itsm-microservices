package com.itsm.domain


import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity(name = "category_table")
data class Category(
    @Id
    @GeneratedValue
    val id: UUID? = null,
    @NotNull
    @Column(name = "name", nullable = false, unique = true)
    val name: String,
)

