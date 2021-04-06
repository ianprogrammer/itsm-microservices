package com.itsm.controller

import com.itsm.domain.User
import com.itsm.dto.UserDTO
import com.itsm.repository.contracts.UserRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.scheduling.TaskExecutors
import io.micronaut.scheduling.annotation.ExecuteOn
import java.util.*

import io.micronaut.validation.Validated
import javax.inject.Inject
import javax.validation.Valid

//38837a22-fa32-4029-809a-c1bbc20eb7e8
//a5a1ee18-fbe9-413b-89f0-4b411f70618e
@ExecuteOn(TaskExecutors.IO)
@Controller("/user")
@Validated
class UserController(
    @Inject
    private val userRepository: UserRepository
) {

    @Get("/{id}")
    fun show(id: UUID): HttpResponse<User> {
        return HttpResponse.ok(
            userRepository
                .findById(id).orElse(null)
        )
    }

    @Put("/{id}")
    fun update(@Body @Valid data: UserDTO, id: UUID): HttpResponse<*> {
        val numberOfEntitiesUpdated: Int = userRepository.update(id, data)
        return HttpResponse
            .noContent<Any>()
    }

    @Post
    fun save(@Body @Valid data: UserDTO): HttpResponse<User> {
        val user = userRepository.save(data)
        return HttpResponse.created(user)
    }

    @Delete("/{id}")
    fun delete(id: UUID): HttpResponse<*>? {
        userRepository.deleteById(id)
        return HttpResponse.noContent<Any>()
    }

}