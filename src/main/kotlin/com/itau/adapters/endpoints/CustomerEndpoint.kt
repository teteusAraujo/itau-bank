package com.itau.adapters.endpoints

import com.itau.CustomerRequest
import com.itau.CustomerResponse
import com.itau.CustomerServiceGrpc
import com.itau.application.ports.input.CreateCustomerUseCase
import com.itau.domain.Customer
import io.grpc.stub.StreamObserver
import jakarta.inject.Singleton

@Singleton
class CustomerEndpoint(private val createCustomerUseCase: CreateCustomerUseCase) : CustomerServiceGrpc.CustomerServiceImplBase(){
    override fun create(request: CustomerRequest?, responseObserver: StreamObserver<CustomerResponse>?) {
        val customerRequest = Customer(
            id = null,
            name = request!!.name,
            cpf = request.cpf
        )
        val customerSaved = createCustomerUseCase.execute(customerRequest)
        val customerRes = CustomerResponse.newBuilder()
            .setId(customerSaved.id!!)
            .setName(customerSaved.name)
            .setCpf(customerSaved.cpf)
            .build()

        responseObserver?.onNext(customerRes)
        responseObserver?.onCompleted()
    }
}