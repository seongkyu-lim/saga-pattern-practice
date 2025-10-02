package org.example.account.presentation

import org.example.account.application.AccountService
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import java.util.UUID


data class TransferredEventDto(
    val amount: String,
    val senderAccountId: UUID,
    val bankName: String,
    val receiverBankAccountNumber: String
)


@Component
class KafkaListener(
    private val accountService: AccountService
) {

    @KafkaListener(topics = ["Transferred"], containerFactory = "kafkaListenerContainerFactory")
    fun listenTransferred(event: TransferredEventDto) {
        println("Received event: $event")
        accountService.updateBalance(event);
    }
}