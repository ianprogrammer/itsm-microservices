package com.itsm.service.impl

import com.itsm.config.CategoryClient
import com.itsm.config.ItemClient
import com.itsm.domain.EventBuilder
import com.itsm.dto.EventBuilderDTO
import com.itsm.rabbit.EventBuilderQueuePublish
import com.itsm.service.contract.EventBuilderService
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

@Singleton
open class EventBuilderServiceImpl(

    private val itemClient: ItemClient,
    private val categoryClient: CategoryClient,
    private val eventBuilderQueuePublish: EventBuilderQueuePublish
) : EventBuilderService{
    override fun sendToQueue(eventBuilderDTO: EventBuilderDTO) {
        kotlin.runCatching {
            val item = itemClient.get(eventBuilderDTO.item.toString()).blockingGet()
            val category = categoryClient.get(eventBuilderDTO.category.toString()).blockingGet()
            val eventBuilder = EventBuilder(item, category)
            eventBuilderQueuePublish.send(eventBuilder)


        }
    }

}