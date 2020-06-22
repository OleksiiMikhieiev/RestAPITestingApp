package omikhieiev.app.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import omikhieiev.app.domain.Result
import omikhieiev.app.domain.boundaries.app.TransactionsUseCase
import omikhieiev.app.domain.data.Transaction

class MainScreenViewModel @ViewModelInject constructor(private val transactionsUseCase: TransactionsUseCase) : ViewModel() {

    private val _getTransactionsResult: MutableLiveData<List<Transaction>> = MutableLiveData()
    val transactions: LiveData<List<Transaction>> = _getTransactionsResult

    fun getAllTransactions() {
        viewModelScope.launch {
            val result = transactionsUseCase.getAllTransactions()
            when (result) {
                is Result.Success -> _getTransactionsResult.postValue(result.data)
            }
        }
    }


}