package com.itsm.repository.impl

import com.itsm.domain.Item
import com.itsm.dto.ItemDTO
import com.itsm.dto.toDomain
import com.itsm.repository.contracts.ItemRepository
import io.micronaut.transaction.annotation.ReadOnly
import java.util.*
import javax.inject.Singleton
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.transaction.Transactional

@Singleton
open class ItemRepositoryImpl(
    @PersistenceContext
    private val entityManager: EntityManager
) : ItemRepository {

    @ReadOnly
    override fun findById(id: UUID): Optional<Item> {
        return Optional.ofNullable(entityManager.find(Item::class.java, id))
    }

    @Transactional
    override fun save(data: ItemDTO): Item {
        val domain = data.toDomain()
        entityManager.persist(domain)
        return domain
    }

    @Transactional
    override fun deleteById(id: UUID) {
        findById(id).ifPresent(entityManager::remove);
    }

    @Transactional
    override fun update(id: UUID, data: ItemDTO): Int {
        return entityManager.createQuery("UPDATE item_table u SET name = :name where id = :id")
            .setParameter("name", data.name)
            .setParameter("id", id)
            .executeUpdate();
    }
}