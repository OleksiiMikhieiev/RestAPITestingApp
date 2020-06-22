package omikhieiev.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import omikhieiev.app.data.LoginRepository
import omikhieiev.app.data.TransactionsRepository
import omikhieiev.app.data.netowrking.RestService
import omikhieiev.app.domain.boundaries.data.LoginDataSource
import omikhieiev.app.domain.boundaries.data.TransactionsDataSource

@Module
@InstallIn(ApplicationComponent::class)
object DataModule {

    @Provides
    fun provideLoginDataSource(restService: RestService): LoginDataSource = LoginRepository(restService)

    @Provides
    fun provideTransactionsDataSource(restService: RestService): TransactionsDataSource = TransactionsRepository(restService)

}