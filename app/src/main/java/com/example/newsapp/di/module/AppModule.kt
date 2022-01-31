package com.example.newsapp.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.newsapp.BuildConfig
import com.example.newsapp.data.ArticleDataSource
import com.example.newsapp.data.ArticleDetailsDataSource
import com.example.newsapp.data.ArticleFavoritesDataSource
import com.example.newsapp.data.local.AppDatabase
import com.example.newsapp.data.remote.ApiService
import com.example.newsapp.di.ApiInfo
import com.example.newsapp.domain.repository.ArticleDetailsRepository
import com.example.newsapp.domain.repository.ArticleFavoritesRepository
import com.example.newsapp.domain.repository.ArticleRepository
import com.example.newsapp.utils.AppConstants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @ApiInfo
    fun provideApiKey(): String {
        return BuildConfig.API_KEY
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create<ApiService>(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, AppConstants.DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideArticleDataSource(ArticleRepository: ArticleRepository): ArticleDataSource {
        return ArticleRepository
    }

    @Provides
    @Singleton
    fun provideArticleDetailsDataSource(ArticleDetailsRepository: ArticleDetailsRepository): ArticleDetailsDataSource {
        return ArticleDetailsRepository
    }

    @Provides
    @Singleton
    fun provideArticleFavoritesDataSource(ArticleFavoritesRepository: ArticleFavoritesRepository): ArticleFavoritesDataSource {
        return ArticleFavoritesRepository
    }
}