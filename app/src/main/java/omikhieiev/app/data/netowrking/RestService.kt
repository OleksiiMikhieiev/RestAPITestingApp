package omikhieiev.app.data.netowrking

import omikhieiev.app.data.netowrking.data.Constants
import omikhieiev.app.data.netowrking.data.LoginData
import omikhieiev.app.data.netowrking.data.LoginResponse
import omikhieiev.app.data.netowrking.data.TransactionResponse
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface RestService {

    @POST(Constants.loginUrl)
    suspend fun login(@Body loginData: LoginData): LoginResponse

    @POST(Constants.dataUrl)
    suspend fun getTransactions(@Header("X-AUTH-TOKEN") token: String): TransactionResponse

}