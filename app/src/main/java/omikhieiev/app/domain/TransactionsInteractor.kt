package omikhieiev.app.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import omikhieiev.app.domain.boundaries.app.TransactionsUseCase
import omikhieiev.app.domain.boundaries.data.TransactionsDataSource
import omikhieiev.app.domain.data.AuthDataHolder
import omikhieiev.app.domain.data.Transaction

class TransactionsInteractor(private val transactionsDataSource: TransactionsDataSource, private val authDataHolder: AuthDataHolder): TransactionsUseCase {

    override suspend fun getAllTransactions(): Result<List<Transaction>> {
        return transactionsDataSource.getAllTransactions(authDataHolder.authData)
    }

    override suspend fun calculateAverage(transactions: List<Transaction>): Double =
        withContext(Dispatchers.Default) {
            val sum = calculateSum(transactions)
            sum / transactions.size
        }


    override suspend fun calculateSum(transactions: List<Transaction>): Double =
        withContext(Dispatchers.Default) {
            var sum = 0.0
            transactions.forEach {
                sum += it.sourceAmount
            }

            sum
        }
}