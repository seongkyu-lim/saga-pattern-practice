package org.example.ledger.presentation

import org.example.ledger.application.LedgerService
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
class KafkaListener (
    private val ledgerService: LedgerService
){
    @KafkaListener(topics = ["Transferred"], containerFactory = "kafkaListenerContainerFactory")
    fun listenTransferred(event: String) {
        println("Received event $event")
        ledgerService.recordLedger(event)
    }
}