package com.itau.application.ports.output

import com.itau.domain.Customer

interface CustomerRepository {
    fun create(customer: Customer): Customer
}