package com.itsm.rabbitmq

import com.itsm.dto.EventBuilderDTO
import com.itsm.dto.toDomain
import com.itsm.repository.contract.EventBuilderRepository
import io.micronaut.rabbitmq.annotation.Queue
import io.micronaut.rabbitmq.annotation.RabbitListener
import org.slf4j.LoggerFactory
import javax.inject.Inject

@RabbitListener
class QueueConsumer(
    @Inject
    private val eventBuilderRepository: EventBuilderRepository
) {
    @Queue("\${eventbuilder.queue}")
    fun paymentData(data: EventBuilderDTO) {
        logger.info("## Getting from queue ##")
        logger.info("Item Id: " + data.item.id)
        logger.info("Category Status: " + data.category.id)
        logger.info("##############################################")
        eventBuilderRepository.save(data)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(QueueConsumer::class.java)
    }
}