package com.example.springboot.context

import com.example.springboot.dto.ErrorDto
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler


@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
class ExceptionHandler {
    @ExceptionHandler(MovieNotFoundException::class)
    fun handle(e: MovieNotFoundException): ResponseEntity<ErrorDto> =
            ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ErrorDto())
}
