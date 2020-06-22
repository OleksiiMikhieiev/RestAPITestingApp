package omikhieiev.app.data.netowrking.data

import com.google.gson.annotations.JsonAdapter
import omikhieiev.app.data.netowrking.json.TransactionDeserializer
import omikhieiev.app.domain.data.Transaction

@JsonAdapter(TransactionDeserializer::class)
data class TransactionResponse(val transactions: List<Transaction>) {
}