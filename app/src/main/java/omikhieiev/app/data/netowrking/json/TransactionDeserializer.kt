package omikhieiev.app.data.netowrking.json

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import omikhieiev.app.data.netowrking.data.TransactionResponse
import omikhieiev.app.data.netowrking.json.DeserializationConstants.data
import omikhieiev.app.data.netowrking.json.DeserializationConstants.reference
import omikhieiev.app.data.netowrking.json.DeserializationConstants.sourceAmount
import omikhieiev.app.data.netowrking.json.DeserializationConstants.status
import omikhieiev.app.data.netowrking.json.DeserializationConstants.transactions
import omikhieiev.app.domain.data.Transaction
import java.lang.reflect.Type

class TransactionDeserializer: JsonDeserializer<TransactionResponse> {

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): TransactionResponse {
        if (json == null)
            throw IllegalArgumentException("Invalid response")

        android.util.Log.d("TST", json.toString())
        val list = json.asJsonObject[data].asJsonObject[transactions].asJsonArray.map {
            val transactionJson = it.asJsonObject
            val reference = transactionJson[reference].asString
            val status = transactionJson[status].asString
            val amount = transactionJson[sourceAmount].asDouble
            Transaction(reference, amount, status)
        }
        return TransactionResponse(list)
    }
}