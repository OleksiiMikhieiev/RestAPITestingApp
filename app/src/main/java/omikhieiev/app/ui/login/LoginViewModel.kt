package omikhieiev.app.ui.login

import androidx.lifecycle.ViewModel
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import omikhieiev.app.domain.Result

import omikhieiev.app.domain.boundaries.app.LoginUseCase

class LoginViewModel @ViewModelInject constructor(private val loginUseCase: LoginUseCase) : ViewModel() {

    private val _loginResult: MutableLiveData<LoginResult> = MutableLiveData()
    val loginResult: LiveData<LoginResult> = _loginResult

    fun login(email: String, password: String) {
        // can be launched in a separate asynchronous job
        viewModelScope.launch {
            val result = loginUseCase.login(email, password)

            when (result) {
                is Result.Success -> _loginResult.postValue(Success)
                is Result.Error -> _loginResult.postValue(Error(result.message))
            }

        }
    }
}