package com.itau.adapters.persistence.entities

import com.itau.domain.Customer
import javax.persistence.*

@Entity(name = "customer")
data class CustomerEntity(
    @Id
    @Column(name = "id_customer")
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    val id: Long ?,
    val name: String,
    val cpf: String
) {
    fun toDomain(): Customer =
        Customer(
            id = id,
            name = name,
            cpf = cpf
        )

    companion object {
        fun fromDomain(customer: Customer): CustomerEntity {
            var id: Long? = null
            if (customer.id != null) {
                id = customer.id
            }
            return CustomerEntity(
                id = id,
                name = customer.name,
                cpf = customer.cpf,
            )
        }
    }
}