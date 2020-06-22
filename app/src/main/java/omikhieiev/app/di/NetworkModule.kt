package omikhieiev.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import omikhieiev.app.data.netowrking.RestService
import omikhieiev.app.data.netowrking.data.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Provides
    fun provideRemitService(): RestService {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(RestService::class.java)
    }

}