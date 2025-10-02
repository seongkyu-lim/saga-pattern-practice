package org.example.account.application

import org.example.account.domain.entity.Account
import org.example.account.domain.repository.AccountRepository
import org.example.account.presentation.TransferredEventDto
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import java.util.Optional
import java.util.UUID

fun <T> Optional<T>.orNull(): T? = orElse(null)

@Service
class AccountService(
    private val accountRepository: AccountRepository,
    private val kafkaTemplate: KafkaTemplate<String, String>
) {
    fun updateBalance(dto: TransferredEventDto) {
        // 계정 잔고 갱신.
        accountRepository.findById(dto.senderAccountId).orNull()?.apply {
                this.balance += dto.amount.toLong();
        }?.also {
            accountRepository.save(it)
        } ?: {
            accountRepository.save(Account.from(dto.senderAccountId, dto.amount.toLong()))
        }
    }
}