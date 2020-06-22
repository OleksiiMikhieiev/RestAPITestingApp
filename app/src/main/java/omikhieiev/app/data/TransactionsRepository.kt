package omikhieiev.app.data

import omikhieiev.app.domain.Result
import omikhieiev.app.domain.data.AuthData
import omikhieiev.app.domain.boundaries.data.TransactionsDataSource
import omikhieiev.app.domain.data.Transaction

class TransactionsRepository: TransactionsDataSource {

    override suspend fun getAllTransactions(authData: AuthData): Result<List<Transaction>> {
        TODO("Not yet implemented")
    }
}