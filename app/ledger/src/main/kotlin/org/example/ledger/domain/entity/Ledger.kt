package org.example.ledger.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.util.Date
import java.util.UUID

@Entity
class Ledger(
    @Id
    private val id: UUID = UUID.randomUUID(),
    @Column(name = "created_at", updatable = false)
    @CreatedDate
    private val createdAt: Date? = null,
    @Column(name = "updated_at")
    @LastModifiedDate
    private val updatedAt: Date? = null,
    @Column(name = "text")
    private val text: String,
) {
}