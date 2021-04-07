package com.itsm.repository.contract

import com.itsm.domain.EventBuilder
import com.itsm.dto.EventBuilderDTO
import javax.validation.constraints.NotNull

interface EventBuilderRepository {

    fun save(@NotNull data: EventBuilderDTO): EventBuilder
}