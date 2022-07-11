package org.polik.reactivekotlinrestapi.repository

import org.polik.reactivekotlinrestapi.model.Employee
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Mono

@Transactional(readOnly = true)
interface EmployeeRepository : ReactiveCrudRepository<Employee, Long> {

    @Transactional
    fun save(employee: Mono<Employee>): Mono<Employee>
}