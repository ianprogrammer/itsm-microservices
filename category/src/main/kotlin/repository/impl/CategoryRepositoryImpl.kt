package com.itsm.repository.impl

import com.itsm.domain.Category
import com.itsm.dto.CategoryDTO
import com.itsm.dto.toDomain
import com.itsm.repository.contracts.CategoryRepository

import java.util.*
import javax.inject.Singleton
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext


@Singleton
open class CategoryRepositoryImpl(
    @PersistenceContext
    private val entityManager: EntityManager
) : CategoryRepository {
    override fun findById(id: UUID): Optional<Category> {
        return Optional.ofNullable(entityManager.find(Category::class.java, id))
    }

    override fun save(data: CategoryDTO): Category {
        val domain = data.toDomain()
        entityManager.persist(domain)
        return domain
    }

    override fun deleteById(id: UUID) {
        findById(id).ifPresent(entityManager::remove);
    }

    override fun update(id: UUID, data: CategoryDTO): Int {
        return entityManager.createQuery("UPDATE category_table u SET name = :name where id = :id")
            .setParameter("name", data.name)
            .setParameter("id", id)
            .executeUpdate();
    }
}