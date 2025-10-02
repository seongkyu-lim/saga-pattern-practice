package org.example.transfer.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.example.transfer.presentation.controller.TransferReqDto
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.util.Date
import java.util.UUID

@Entity
class TransferHistory(
    @Id()
    private val id: UUID = UUID.randomUUID(),
    @Column(name = "created_at", updatable = false)
    @CreatedDate
    private val createdAt: Date? = null,
    @Column(name = "updated_at")
    @LastModifiedDate
    private val updatedAt: Date? = null,
    @Column(name = "amount")
    private val amount: String,
    @Column(name = "sender_account_id")
    private val senderAccountId: UUID,
    @Column(name = "receiver_bank_account_number")
    private val receiverBankAccountNumber: String,
    @Column(name = "receiver_bank_name")
    private val receiverBankName: String,
    @Column(name = "receiver_account_id")
    private val receiverAccountId: UUID? = null,
){
    companion object{
        fun from(dto: TransferReqDto) = TransferHistory(
            amount = dto.amount,
            senderAccountId = dto.senderAccountId,
            receiverBankName = dto.bankName,
            receiverBankAccountNumber = dto.receiverBankAccountNumber,
        )
    }
}