package com.example.newsapp.domain.repository

import com.example.newsapp.data.ArticleDetailsDataSource
import com.example.newsapp.data.local.AppDatabase
import com.example.newsapp.data.remote.ApiService
import com.example.newsapp.di.ApiInfo
import com.example.newsapp.domain.dto.Result
import com.example.newsapp.domain.dto.db.Article
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticleDetailsRepository @Inject constructor(
    private val mAppDatabase: AppDatabase,
    private val apiService: ApiService,
    @param:ApiInfo private val apiKey: String
) : ArticleDetailsDataSource {
    override suspend fun insert(article: Article) = mAppDatabase.articleDao().insert(article)
    override suspend fun delete(article: Article) = mAppDatabase.articleDao().delete(article)
    override suspend fun getFavoriteById(id: Long): Result<Article> {
        return try {
            Result.Success(mAppDatabase.articleDao().getFavoriteById(id))
        } catch (e: Exception) {
            Result.Error(e.localizedMessage)
        }
    }
}