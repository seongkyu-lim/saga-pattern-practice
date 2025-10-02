package org.example.transfer.domain.repository

import org.example.transfer.domain.entity.TransferHistory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface TransferHistoryRepository: JpaRepository<TransferHistory, UUID> {
    fun save(entity: TransferHistory): TransferHistory
}