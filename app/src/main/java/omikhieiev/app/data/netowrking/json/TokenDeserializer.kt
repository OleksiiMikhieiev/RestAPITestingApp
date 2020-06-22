package omikhieiev.app.data.netowrking.json

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import omikhieiev.app.data.netowrking.data.LoginResponse
import omikhieiev.app.data.netowrking.json.DeserializationConstants.data
import omikhieiev.app.data.netowrking.json.DeserializationConstants.token
import java.lang.reflect.Type

class TokenDeserializer: JsonDeserializer<LoginResponse> {

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): LoginResponse {

        if (json == null)
            throw IllegalArgumentException("Invalid response")

        android.util.Log.d("TST", json.toString())

        val token = json.asJsonObject[data].asJsonObject[token].asJsonObject[token].asString
        return LoginResponse(token)
    }
}