package teko.ch.kotlinvuefinance.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import teko.ch.kotlinvuefinance.models.Expense

@Repository
interface ExpenseRepository : JpaRepository<Expense, Int>