package com.itsm.dto

import com.itsm.domain.User
import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

@Introspected
class UserDTO {
    @NotEmpty(message = "Name may not be empty")
    var name = ""

    @NotEmpty(message = "email may not be empty")
    @Email(message = "Email should be valid")
    var email = ""
}


fun UserDTO.toDomain(): User = User(name = this.name, email = this.email)
