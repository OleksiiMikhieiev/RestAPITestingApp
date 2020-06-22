package omikhieiev.app.domain

import omikhieiev.app.domain.boundaries.app.TransactionsUseCase
import omikhieiev.app.domain.boundaries.data.TransactionsDataSource
import omikhieiev.app.domain.data.Transaction

class TransactionsInteractor(private val transactionsDataSource: TransactionsDataSource): TransactionsUseCase {

    override suspend fun getAllTransactions(): Result<List<Transaction>> {
        TODO("Not yet implemented")
    }

    override suspend fun calculateAverage(transactions: List<Transaction>): Double {
        val sum = calculateSum(transactions)

        return sum.toDouble() / transactions.size
    }

    override suspend fun calculateSum(transactions: List<Transaction>): Int {
        var sum = 0

        transactions.forEach {
            sum += it.sourceAmount
        }

        return sum
    }
}