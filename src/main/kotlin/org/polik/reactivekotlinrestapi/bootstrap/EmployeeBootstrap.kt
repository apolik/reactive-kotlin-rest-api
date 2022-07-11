package org.polik.reactivekotlinrestapi.bootstrap

import org.polik.reactivekotlinrestapi.model.Employee
import org.polik.reactivekotlinrestapi.service.EmployeeService
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
class EmployeeBootstrap(private val service: EmployeeService) : CommandLineRunner {
    private val log = LoggerFactory.getLogger(this.javaClass)

    override fun run(vararg args: String?) {
        log.info("Creating employees..")

        val employee1 = Employee(null, "Longinus Harun", "tre24@yahoo.com", BigDecimal(5000.0))
        val employee2 = Employee(null, "Michaias Aziel", "kaylee.cruickshank@yahoo.com", BigDecimal(7800.0))
        val employee3 = Employee(null, "Reşide Stanislava", "leonel_hahn0@hotmail.com", BigDecimal(4500.0))
        val employee4 = Employee(null, "Iacob Pheobe", "carmela60@gmail.com", BigDecimal(3850.0))
        val employee5 = Employee(null, "Djuradj Radulf", "carmella19@gmail.com", BigDecimal(8700.0))

        service.create(employee1).block()
        service.create(employee2).block()
        service.create(employee3).block()
        service.create(employee4).block()
        service.create(employee5).block()

        log.info("Employees have been created!")
    }
}