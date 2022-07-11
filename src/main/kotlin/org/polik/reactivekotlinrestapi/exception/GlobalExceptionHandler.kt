package org.polik.reactivekotlinrestapi.exception

import org.springframework.boot.context.properties.bind.validation.BindValidationException
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.validation.BindException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.support.WebExchangeBindException
import javax.validation.ValidationException

@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(
        value = [
            NotFoundException::class,
            NoSuchElementException::class
        ]
    )
    fun handleNotFound(): ResponseEntity<ErrorInfo> {
        return createResponseEntity(HttpStatus.NOT_FOUND, NOT_FOUND_MESSAGE)
    }

    @ExceptionHandler(
        value = [
            IllegalStateException::class,
            ValidationException::class,
            BindException::class,
            MethodArgumentNotValidException::class,
            HttpMessageNotReadableException::class,
            DataIntegrityViolationException::class,
            WebExchangeBindException::class,
            BindValidationException::class
        ]
    )
    fun handleValidationErrors(): ResponseEntity<ErrorInfo> {
        return createResponseEntity(HttpStatus.BAD_REQUEST, VALIDATION_MESSAGE)
    }

    @Suppress("unchecked_cast")
    private fun <T> createResponseEntity(status: HttpStatus, message: String): ResponseEntity<T> {
        return ResponseEntity.status(status).body(ErrorInfo(status.value(), message)) as ResponseEntity<T>
    }

    companion object {
        const val VALIDATION_MESSAGE = "Validation Failed"
        const val NOT_FOUND_MESSAGE = "Student not found"
    }
}