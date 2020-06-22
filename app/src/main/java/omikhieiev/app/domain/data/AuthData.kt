package omikhieiev.app.domain.data

/**
 * Data class that captures auth information for logged in users retrieved from LoginRepository
 */
data class AuthData(
        val token: String
)