package org.polik.reactivekotlinrestapi.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.validator.constraints.Length
import org.hibernate.validator.constraints.Range
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.math.BigDecimal
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Table("employees")
data class Employee (
    @Id
    var id: Long?,

    @field:NotBlank
    @field:Length(min = 2, max = 40)
    val name: String,

    @field:Email
    @field:NotNull
    val email: String,

    @field:Range(min = 0, max = 1_000_000_000)
    @field:NotNull
    val salary: BigDecimal
) {
    @JsonIgnore
    fun isNew(): Boolean {
        return id == null
    }
}
