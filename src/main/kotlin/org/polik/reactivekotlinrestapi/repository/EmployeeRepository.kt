package org.polik.reactivekotlinrestapi.repository

import org.polik.reactivekotlinrestapi.model.Employee
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface EmployeeRepository : ReactiveCrudRepository<Employee, Long>