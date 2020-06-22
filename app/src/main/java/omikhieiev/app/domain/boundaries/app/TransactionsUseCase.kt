package omikhieiev.app.domain.boundaries.app

import omikhieiev.app.domain.Result
import omikhieiev.app.domain.data.Transaction

interface TransactionsUseCase {

    suspend fun getAllTransactions(): Result<List<Transaction>>

    suspend fun calculateAverage(transactions: List<Transaction>): Double
    suspend fun calculateSum(transactions: List<Transaction>): Double

}