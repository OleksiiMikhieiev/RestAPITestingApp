package omikhieiev.app

import omikhieiev.app.domain.TransactionsInteractor
import omikhieiev.app.domain.data.AuthData
import omikhieiev.app.domain.data.AuthDataHolder
import omikhieiev.app.mocks.AuthDataMock
import omikhieiev.app.mocks.TransactionsProviderMock
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MathOperationsTest {

    @Test
    fun sum_isCorrect() {
        val dataAmount = arrayOf(1.0, 2.0, 3.0)
        val expectedSum = 6.0
        val delta = 0.0

        val dataMock = TransactionsProviderMock(dataAmount)
        val authDataMock = AuthDataMock.getAuthDataHolder()

        val useCase = TransactionsInteractor(dataMock, authDataMock)

        val actualSum = useCase.calculateSum(dataMock.getAllTransactions())

        assertEquals(expectedSum, actualSum, delta)
    }

    @Test
    fun average_isCorrect() {
        val dataAmount = arrayOf(1.0, 2.0, 3.0)
        val expectedAverage = 2.0
        val delta = 0.0

        val dataMock = TransactionsProviderMock(dataAmount)
        val authDataMock = AuthDataMock.getAuthDataHolder()

        val useCase = TransactionsInteractor(dataMock, authDataMock)

        val actualAvg = useCase.calculateAverage(dataMock.getAllTransactions())

        assertEquals(expectedAverage, actualAvg, delta)
    }
}