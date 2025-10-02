package org.example.transfer.application

import org.example.transfer.domain.entity.TransferHistory
import org.example.transfer.domain.repository.TransferHistoryRepository
import org.example.transfer.presentation.controller.TransferReqDto
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class TransferService(
    private val transferHistoryRepository: TransferHistoryRepository,
    private val kafkaTemplate: KafkaTemplate<String, String>
) {
    fun transfer(body: TransferReqDto) {
        // 계좌 송금 외부 시스템 호출.

        // 송금 내역 저장.
        transferHistoryRepository.save(TransferHistory.from(body))

        // Transfered Event 발행.
        kafkaTemplate.send("Transferred", body.toString())
    }
}