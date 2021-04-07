package com.itsm.domain


import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity(name = "event_table")
data class EventBuilder(
    @Id
    @GeneratedValue
    val id: UUID? = null,
    @NotNull
    @Column( nullable = false)
    val item: UUID,
    @NotNull
    @Column(nullable = false)
    val category: UUID,
)
