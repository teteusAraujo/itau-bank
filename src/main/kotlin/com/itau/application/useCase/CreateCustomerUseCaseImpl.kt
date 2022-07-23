package com.itau.application.useCase

import com.itau.application.ports.input.CreateCustomerUseCase
import com.itau.application.ports.output.CustomerRepository
import com.itau.domain.Customer
import jakarta.inject.Singleton

@Singleton
class CreateCustomerUseCaseImpl(private val customerRepository: CustomerRepository): CreateCustomerUseCase {
    override fun execute(customer: Customer): Customer {
        return customerRepository.create(customer)
    }
}