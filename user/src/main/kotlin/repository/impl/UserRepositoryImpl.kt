package com.itsm.repository.impl

import com.itsm.domain.User
import com.itsm.dto.UserDTO
import com.itsm.dto.toDomain
import com.itsm.repository.contracts.UserRepository
import io.micronaut.transaction.annotation.ReadOnly
import java.util.*
import javax.inject.Singleton
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.transaction.Transactional

@Singleton
open class UserRepositoryImpl(
    @PersistenceContext
    private val entityManager: EntityManager
) : UserRepository {

    @ReadOnly
    override fun findById(id: UUID): Optional<User> {
        return Optional.ofNullable(entityManager.find(User::class.java, id))
    }

    @Transactional
    override fun save(data: UserDTO): User {
        val domain = data.toDomain()
        entityManager.persist(domain)
        return domain
    }

    @Transactional
    override fun deleteById(id: UUID) {
        findById(id).ifPresent(entityManager::remove);
    }

    @Transactional
    override fun update(id: UUID, data: UserDTO): Int {
        return entityManager.createQuery("UPDATE user_table u SET name = :name, email = :email where id = :id")
            .setParameter("name", data.name)
            .setParameter("email", data.email)
            .setParameter("id", id)
            .executeUpdate();
    }
}