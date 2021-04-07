package com.itsm.repository.impl

import com.itsm.domain.EventBuilder
import com.itsm.dto.EventBuilderDTO
import com.itsm.dto.toDomain
import com.itsm.repository.contract.EventBuilderRepository
import javax.inject.Singleton
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.transaction.Transactional

@Singleton
open class EventBuilderRepositoryImpl(
    @PersistenceContext
    private val entityManager: EntityManager
) : EventBuilderRepository {
    @Transactional
    override fun save(data: EventBuilderDTO): EventBuilder {
        val domain = data.toDomain()
        entityManager.persist(domain)
        return domain
    }
}