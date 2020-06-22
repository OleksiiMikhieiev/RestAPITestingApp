package omikhieiev.app.mocks

import omikhieiev.app.domain.Result
import omikhieiev.app.domain.boundaries.data.TransactionsDataSource
import omikhieiev.app.domain.data.AuthData
import omikhieiev.app.domain.data.Transaction

class TransactionsProviderMock(private val amountData: Array<Double>): TransactionsDataSource {

    override suspend fun getAllTransactions(authData: AuthData): Result<List<Transaction>> {
        val list = getAllTransactions()
        return Result.Success(list)
    }

    fun getAllTransactions(): List<Transaction> {
        return amountData.map {
            Transaction("stub", it, "stub")
        }
    }

}