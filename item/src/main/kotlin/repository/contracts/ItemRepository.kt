package com.itsm.repository.contracts

import com.itsm.domain.Item
import com.itsm.dto.ItemDTO
import java.util.*
import javax.validation.constraints.NotNull

interface ItemRepository {
    fun findById(@NotNull id: UUID): Optional<Item>

    fun save(@NotNull data: ItemDTO): Item

    fun deleteById(id: @NotNull UUID)

    fun update(id: @NotNull UUID, @NotNull itemDTO: ItemDTO): Int
}