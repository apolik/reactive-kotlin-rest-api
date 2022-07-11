package org.polik.reactivekotlinrestapi.controller

import org.polik.reactivekotlinrestapi.model.Employee
import org.polik.reactivekotlinrestapi.service.EmployeeService
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import javax.validation.Valid

@Validated
@RestController
@RequestMapping("/api/employees")
class EmployeeController(private val service: EmployeeService) {
    @GetMapping
    fun getAll(): Flux<Employee> {
        return service.getAll()
    }

    @PostMapping
    fun create(@Valid @RequestBody employee: Employee): Mono<Employee> {
        return service.create(employee)
    }

    @PutMapping("/{id}")
    fun update(
        @Valid @RequestBody employee: Employee,
        @PathVariable id: Long
    ): Mono<Void> {
        return service.update(employee, id)
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): Mono<Employee> {
        return service.get(id)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): Mono<Void> {
        return service.delete(id)
    }
}