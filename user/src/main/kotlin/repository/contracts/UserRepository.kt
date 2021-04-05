package com.itsm.repository.contracts

import com.itsm.domain.User
import com.itsm.dto.UserDTO
import java.util.*
import javax.validation.constraints.NotNull

interface UserRepository {

    fun findById(@NotNull id: UUID): Optional<User>

    fun save(@NotNull data: UserDTO): User

    fun deleteById(id: @NotNull UUID)

    fun update(id: @NotNull UUID, @NotNull userDTO: UserDTO): Int
}