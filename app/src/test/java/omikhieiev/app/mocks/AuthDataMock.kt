package omikhieiev.app.mocks

import omikhieiev.app.domain.data.AuthData
import omikhieiev.app.domain.data.AuthDataHolder

object AuthDataMock {

    fun getAuthDataHolder(): AuthDataHolder {
        val holder = AuthDataHolder()
        holder.authData = AuthData("stub")
        return holder
    }

}