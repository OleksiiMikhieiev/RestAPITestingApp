package omikhieiev.app.data.netowrking.data

import com.google.gson.annotations.JsonAdapter
import omikhieiev.app.data.netowrking.json.TokenDeserializer

@JsonAdapter(TokenDeserializer::class)
data class LoginResponse (val token: String) {
}