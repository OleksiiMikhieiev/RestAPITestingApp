package omikhieiev.app.domain.boundaries.app

import omikhieiev.app.domain.Result

interface LoginUseCase {

    suspend fun login(email: String, password: String): Result<Boolean>

}