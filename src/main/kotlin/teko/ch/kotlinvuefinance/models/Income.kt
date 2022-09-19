package teko.ch.kotlinvuefinance.models

import javax.persistence.*

@Entity
@Table(name="incomes")
class Income {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    var id: Int? = null

    @Column(name="description", nullable = false)
    var description: String? = null

    @Column(name="amount", nullable = false)
    var amount: Double? = null
}