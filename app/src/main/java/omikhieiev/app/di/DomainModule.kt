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

@Module
@InstallIn(ApplicationComponent::class)
object DomainModule {

    @Provides
    fun provideTransactionsUseCase(dataSource: TransactionsDataSource): TransactionsUseCase = TransactionsInteractor(dataSource)

    @Provides
    fun provideLoginUseCase(dataSource: LoginDataSource): LoginUseCase = LoginInteractor(dataSource)
}