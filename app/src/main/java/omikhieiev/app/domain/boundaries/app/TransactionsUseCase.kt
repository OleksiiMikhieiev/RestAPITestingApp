package omikhieiev.app.domain.boundaries.app

import omikhieiev.app.domain.Result
import omikhieiev.app.domain.data.Transaction

/**
 * General definition for Transactions operations.
 */
interface TransactionsUseCase {

    suspend fun getAllTransactions(): Result<List<Transaction>>

    fun calculateAverage(transactions: List<Transaction>): Double
    fun calculateSum(transactions: List<Transaction>): Double

}