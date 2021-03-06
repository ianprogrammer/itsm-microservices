package com.itsm.domain

import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity(name = "user_table")
data class User(
    @Id
    @GeneratedValue
    val id: UUID? = null,
    @NotNull
    @Column(name = "name", nullable = false)
    val name: String,
    @NotNull

    @Column(name = "email", nullable = false, unique = true)
    val email: String,
)
