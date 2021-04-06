package com.itsm.service.contract

import com.itsm.dto.EventBuilderDTO
import javax.validation.constraints.NotNull

interface EventBuilderService {

    fun sendToQueue(@NotNull eventBuilderDTO: EventBuilderDTO)
}