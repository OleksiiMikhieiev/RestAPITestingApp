package omikhieiev.app.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import omikhieiev.app.domain.Result
import omikhieiev.app.domain.boundaries.app.TransactionsUseCase
import omikhieiev.app.domain.data.Transaction
import omikhieiev.app.ui.main.model.GeneralInfo
import kotlin.math.round

/**
 * This class requests transactions and notifies the UI about updates
 */
class MainScreenViewModel @ViewModelInject constructor(private val transactionsUseCase: TransactionsUseCase) : ViewModel() {

    private val _getTransactionsResult: MutableLiveData<List<Transaction>> = MutableLiveData()
    val transactions: LiveData<List<Transaction>> = _getTransactionsResult

    private val _loadingError: MutableLiveData<String> = MutableLiveData()
    val loadingError: LiveData<String> = _loadingError

    private val _generalInfo: MutableLiveData<GeneralInfo> = MutableLiveData()
    val generalInfo: LiveData<GeneralInfo> = _generalInfo

    init {
        // Prepopulate data to the view
        getAllTransactions()
    }

    fun getAllTransactions() {
        viewModelScope.launch {
            val result = transactionsUseCase.getAllTransactions()
            when (result) {
                is Result.Success -> withContext(Dispatchers.Default) {
                        val sum = transactionsUseCase.calculateSum(result.data)
                        val avg = transactionsUseCase.calculateAverage(result.data)
                        _getTransactionsResult.postValue(result.data)
                        _generalInfo.postValue(
                            GeneralInfo(
                                sum,
                                round(avg)
                            )
                        )
                    }
                is Result.Error -> _loadingError.postValue(result.message)
            }
        }
    }

}