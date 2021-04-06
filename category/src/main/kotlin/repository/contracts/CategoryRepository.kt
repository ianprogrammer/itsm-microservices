package com.itsm.repository.contracts


import com.itsm.domain.Category
import com.itsm.dto.CategoryDTO
import java.util.*
import javax.validation.constraints.NotNull

interface CategoryRepository {
    fun findById(@NotNull id: UUID): Optional<Category>

    fun save(@NotNull data: CategoryDTO): Category

    fun deleteById(id: @NotNull UUID)

    fun update(id: @NotNull UUID, @NotNull itemDTO: CategoryDTO): Int
}