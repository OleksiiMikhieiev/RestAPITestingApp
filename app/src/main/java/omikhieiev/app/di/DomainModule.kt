package omikhieiev.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import omikhieiev.app.domain.LoginInteractor
import omikhieiev.app.domain.TransactionsInteractor
import omikhieiev.app.domain.boundaries.app.LoginUseCase
import omikhieiev.app.domain.boundaries.app.TransactionsUseCase
import omikhieiev.app.domain.boundaries.data.LoginDataSource
import omikhieiev.app.domain.boundaries.data.TransactionsDataSource
import omikhieiev.app.domain.data.AuthDataHolder
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DomainModule {

    @Provides
    fun provideTransactionsUseCase(dataSource: TransactionsDataSource, authDataHolder: AuthDataHolder): TransactionsUseCase = TransactionsInteractor(dataSource, authDataHolder)

    @Provides
    fun provideLoginUseCase(dataSource: LoginDataSource, authDataHolder: AuthDataHolder): LoginUseCase = LoginInteractor(dataSource, authDataHolder)

    @Provides
    @Singleton
    fun provideAuthDataHolder(): AuthDataHolder = AuthDataHolder()
}