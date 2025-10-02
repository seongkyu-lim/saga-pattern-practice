package org.example.account.domain.repository

import org.example.account.domain.entity.Account
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface AccountRepository: JpaRepository<Account, UUID> {
    fun save(entity: Account): Account
}