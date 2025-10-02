package org.example.ledger.application

import org.example.ledger.domain.entity.Ledger
import org.example.ledger.domain.repository.LedgerRepository
import org.springframework.stereotype.Service

@Service
class LedgerService(
    private val ledgerRepository: LedgerRepository
) {
    fun recordLedger(event: String) {
        ledgerRepository.save(Ledger(text = event))
    }
}