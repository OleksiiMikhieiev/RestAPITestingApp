package omikhieiev.app.data

import omikhieiev.app.domain.boundaries.data.LoginDataSource
import omikhieiev.app.domain.Result
import omikhieiev.app.domain.data.AuthData

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */
class LoginRepository: LoginDataSource {

    override suspend fun login(email: String, password: String): Result<AuthData> {
        TODO("Not yet implemented")
    }
}