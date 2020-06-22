package omikhieiev.app.domain

import omikhieiev.app.domain.boundaries.app.LoginUseCase
import omikhieiev.app.domain.boundaries.data.LoginDataSource
import omikhieiev.app.domain.data.AuthDataHolder

class LoginInteractor(private val loginDataSource: LoginDataSource, private val authDataHolder: AuthDataHolder): LoginUseCase {

    override suspend fun login(email: String, password: String): Result<Boolean> {
        val loginResult = loginDataSource.login(email, password)
        return when (loginResult) {
            is Result.Success -> {
                authDataHolder.authData = loginResult.data
                Result.Success(true)
            }
            is Result.Error -> Result.Error("Incorrect password")
            else -> Result.Error("Unknown error")
        }
    }
}