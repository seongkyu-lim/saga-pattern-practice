package org.example.ledger.domain.repository

import org.example.ledger.domain.entity.Ledger
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface LedgerRepository: JpaRepository<Ledger, UUID> {
    fun save(entity: Ledger): Ledger
}