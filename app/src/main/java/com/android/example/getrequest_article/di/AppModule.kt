package com.android.example.getrequest_article.di

import com.android.example.getrequest_article.feature_getRequest.data.data_source.MyAPI
import com.android.example.getrequest_article.feature_getRequest.data.repository.MyRepositoryImpl
import com.android.example.getrequest_article.feature_getRequest.domain.repository.MyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideApiInstance() : MyAPI {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideRepositoryInstance(api: MyAPI) : MyRepository {
        return MyRepositoryImpl(api)
    }
}