package teko.ch.kotlinvuefinance.controllers

import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import teko.ch.kotlinvuefinance.models.Income
import teko.ch.kotlinvuefinance.repositories.IncomeRepository

@RestController
@RequestMapping("api/incomes/")
class IncomeController(private val incomeRepository: IncomeRepository) {
    @GetMapping
    fun index(): List<Income> =
        incomeRepository.findAll(Sort.by(Sort.Direction.DESC, "id"))

    @PostMapping
    fun store(@RequestBody income: Income): Income =
        incomeRepository.save(income)

    @DeleteMapping("/{id}")
    fun destroy(@PathVariable(value = "id") id: Int):ResponseEntity<Void> {
        return incomeRepository.findById(id).map{income -> incomeRepository.delete(income)
        ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }
}