package com.itau.adapters.persistence

import com.itau.adapters.persistence.entities.CustomerEntity
import com.itau.adapters.persistence.repositories.CustomerJpaRepository
import com.itau.application.ports.output.CustomerRepository
import com.itau.domain.Customer
import jakarta.inject.Singleton

@Singleton
class CustomerJpaRepositoryImpl( private val customerJpaRepository: CustomerJpaRepository): CustomerRepository {
    override fun create(customer: Customer): Customer {
        val customerSaved = customerJpaRepository.save(CustomerEntity.fromDomain(customer))
        return customerSaved.toDomain()
    }
}