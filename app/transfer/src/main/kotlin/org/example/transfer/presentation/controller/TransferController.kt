package org.example.transfer.presentation.controller

import org.example.transfer.application.TransferService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

data class TransferReqDto(
    val amount: String,
    val senderAccountId: UUID,
    val bankName: String,
    val receiverBankAccountNumber: String
)

@RestController("/transfer")
class TransferController(
    private val transferService: TransferService
) {

    @PostMapping()
    fun transfer(@RequestBody body: TransferReqDto): String {

        transferService.transfer(body)
        return "ok"
    }
}