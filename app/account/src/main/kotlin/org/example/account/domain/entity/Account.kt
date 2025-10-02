package org.example.account.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.util.Date
import java.util.UUID

@Entity
class Account(
    @Id
    private val id: UUID = UUID.randomUUID(),
    @Column(name="created_at", updatable = false)
    @CreatedDate
    private val createdAt: Date? = null,
    @Column(name = "updated_at")
    @LastModifiedDate
    private val updatedAt: Date? = null,
    @Column(name = "balance")
    var balance: Long = 0L,
) {
    companion object {
        fun from(accountId: UUID, balance: Long) = Account(
            id = accountId,
            balance = balance,
        )
    }
}