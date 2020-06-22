package omikhieiev.app.domain.boundaries.data

import omikhieiev.app.domain.data.AuthData
import omikhieiev.app.domain.Result

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
interface LoginDataSource {
    suspend fun login(email: String, password: String): Result<AuthData>
}