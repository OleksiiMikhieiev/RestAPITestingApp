package omikhieiev.app.domain.boundaries.app

import omikhieiev.app.domain.Result

/**
 * General definition for user login flow
 */
interface LoginUseCase {

    suspend fun login(email: String, password: String): Result<Boolean>

}