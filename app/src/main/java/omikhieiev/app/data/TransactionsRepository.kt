package omikhieiev.app.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import omikhieiev.app.data.netowrking.RestService
import omikhieiev.app.domain.Result
import omikhieiev.app.domain.data.AuthData
import omikhieiev.app.domain.boundaries.data.TransactionsDataSource
import omikhieiev.app.domain.data.Transaction

/**
 * Class that retrieves transactions based on auth token via REST API.
 */
class TransactionsRepository(private val restService: RestService): TransactionsDataSource {

    override suspend fun getAllTransactions(authData: AuthData): Result<List<Transaction>> =
        withContext(Dispatchers.IO) {
            try {
                val response = restService.getTransactions(authData.token)
                Result.Success(response.transactions)
            } catch (err: Throwable) {
                err.printStackTrace()
                Result.Error("General error")
            }
        }


}