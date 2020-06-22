package omikhieiev.app.domain

import omikhieiev.app.domain.boundaries.app.TransactionsUseCase
import omikhieiev.app.domain.boundaries.data.TransactionsDataSource
import omikhieiev.app.domain.data.AuthDataHolder
import omikhieiev.app.domain.data.Transaction

/**
 * Implementation for Transaction operations. Uses Boundary interfaces to access data from the Repository.
 */
class TransactionsInteractor(private val transactionsDataSource: TransactionsDataSource, private val authDataHolder: AuthDataHolder): TransactionsUseCase {

    override suspend fun getAllTransactions(): Result<List<Transaction>> {
        return transactionsDataSource.getAllTransactions(authDataHolder.authData)
    }

    override fun calculateAverage(transactions: List<Transaction>): Double {
        val sum = calculateSum(transactions)
        return sum / transactions.size
    }


    override fun calculateSum(transactions: List<Transaction>): Double {
        var sum = 0.0
        transactions.forEach {
            sum += it.sourceAmount
        }
        return sum
    }
}