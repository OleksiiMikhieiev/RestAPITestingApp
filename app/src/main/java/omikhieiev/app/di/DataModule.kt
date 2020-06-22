package omikhieiev.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import omikhieiev.app.data.LoginRepository
import omikhieiev.app.data.TransactionsRepository
import omikhieiev.app.domain.boundaries.data.LoginDataSource
import omikhieiev.app.domain.boundaries.data.TransactionsDataSource

@Module
@InstallIn(ApplicationComponent::class)
object DataModule {

    @Provides
    fun provideLoginDataSource(): LoginDataSource = LoginRepository()

    @Provides
    fun provideTransactionsDataSource(): TransactionsDataSource = TransactionsRepository()

}