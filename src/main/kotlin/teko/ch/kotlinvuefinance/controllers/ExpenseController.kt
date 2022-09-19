package teko.ch.kotlinvuefinance.controllers

import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import teko.ch.kotlinvuefinance.models.Expense
import teko.ch.kotlinvuefinance.repositories.ExpenseRepository

@RestController
@RequestMapping("api/expenses/")
class ExpenseController(private val expenseRepository: ExpenseRepository) {
    @GetMapping
    fun index(): List<Expense> =
        expenseRepository.findAll(Sort.by(Sort.Direction.DESC, "id"))

    @PostMapping
    fun store(@RequestBody expense: Expense): Expense =
        expenseRepository.save(expense)

    @DeleteMapping("/{id}")
    fun destroy(@PathVariable(value = "id") id: Int): ResponseEntity<Void> {
        return expenseRepository.findById(id).map{expense -> expenseRepository.delete(expense)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }
}