package com.example.architecturepatternsinandroid.di

import com.example.architecturepatternsinandroid.data.remote.FakeDataApi
import com.example.architecturepatternsinandroid.data.repository.MovieRepositoryImpl
import com.example.architecturepatternsinandroid.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideFakeDataApi(): FakeDataApi {
        return FakeDataApi()
    }

    @Provides
    @Singleton
    fun provideMovieRepository(
        fakeDataApi: FakeDataApi
    ): MovieRepository{
        return MovieRepositoryImpl(fakeDataApi)
    }
}