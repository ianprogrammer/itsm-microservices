package com.itsm.controller

import com.itsm.dto.EventBuilderDTO
import com.itsm.service.contract.EventBuilderService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.scheduling.TaskExecutors
import io.micronaut.scheduling.annotation.ExecuteOn
import io.micronaut.validation.Validated
import javax.inject.Inject
import javax.validation.Valid
//38837a22-fa32-4029-809a-c1bbc20eb7e8
//a5a1ee18-fbe9-413b-89f0-4b411f70618e
@ExecuteOn(TaskExecutors.IO)
@Controller("/eventbuilder")
@Validated
class EventBuilderController (
    @Inject
    private val eventBuilderService: EventBuilderService
        ) {

    @Post
    fun send(@Body @Valid data: EventBuilderDTO): HttpResponse<*>{
        eventBuilderService.sendToQueue(data)
        return HttpResponse.noContent<String>()
    }
}