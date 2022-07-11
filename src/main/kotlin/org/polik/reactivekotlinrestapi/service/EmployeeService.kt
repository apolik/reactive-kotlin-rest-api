package org.polik.reactivekotlinrestapi.service

import org.polik.reactivekotlinrestapi.model.Employee
import org.polik.reactivekotlinrestapi.repository.EmployeeRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class EmployeeService(private val repository: EmployeeRepository) {
    private val log = LoggerFactory.getLogger(this.javaClass)

    fun getAll(): Flux<Employee> {
        log.info("getAll")
        return repository.findAll()
    }

    fun get(id: Long): Mono<Employee> {
        log.info("get {}", id)
        return repository
            .findById(id)
            .single()
    }

    fun delete(id: Long): Mono<Void> {
        log.info("delete {}", id)
        return repository.deleteById(id)
    }

    fun create(employee: Employee): Mono<Employee> {
        log.info("create {}", employee)
        if (!employee.isNew()) {
            throw IllegalStateException()
        } else {
            return repository.save(employee)
        }
    }

    fun update(employee: Employee, id: Long): Mono<Void> {
        log.info("update {}", employee)
        employee.id = id

        return repository
            .save(employee)
            .then()
    }
}