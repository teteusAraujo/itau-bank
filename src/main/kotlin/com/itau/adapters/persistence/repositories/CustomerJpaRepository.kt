package com.itau.adapters.persistence.repositories

import com.itau.adapters.persistence.entities.CustomerEntity
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface CustomerJpaRepository: JpaRepository<CustomerEntity, Long> {
}