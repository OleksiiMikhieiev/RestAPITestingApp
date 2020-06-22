package omikhieiev.app.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import omikhieiev.app.data.netowrking.RestService
import omikhieiev.app.data.netowrking.data.LoginData
import omikhieiev.app.domain.boundaries.data.LoginDataSource
import omikhieiev.app.domain.Result
import omikhieiev.app.domain.data.AuthData

/**
 * Class that requests auth token via REST API.
 */
class LoginRepository(private val restService: RestService): LoginDataSource {

    override suspend fun login(email: String, password: String): Result<AuthData> =
        withContext(Dispatchers.IO) {
            val loginData = LoginData(email, password)
            try {
                val loginResponse = restService.login(loginData)
                Result.Success(AuthData(loginResponse.token))
            } catch (err: Throwable) {
                err.printStackTrace()
                Result.Error("General error")
            }
        }


}