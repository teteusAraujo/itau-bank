package com.itau.application.ports.input

import com.itau.domain.Customer

interface CreateCustomerUseCase {
    fun execute(customer: Customer): Customer
}