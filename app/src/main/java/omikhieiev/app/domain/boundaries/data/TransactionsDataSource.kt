package omikhieiev.app.domain.boundaries.data

import omikhieiev.app.domain.Result
import omikhieiev.app.domain.data.AuthData
import omikhieiev.app.domain.data.Transaction

interface TransactionsDataSource {
    suspend fun getAllTransactions(authData: AuthData): Result<List<Transaction>>
}