package omikhieiev.app.domain

import omikhieiev.app.domain.boundaries.app.LoginUseCase
import omikhieiev.app.domain.boundaries.data.LoginDataSource

class LoginInteractor(private val loginDataSource: LoginDataSource): LoginUseCase {

    override suspend fun login(email: String, password: String): Result<Nothing> {
        TODO("Not yet implemented")
    }
}