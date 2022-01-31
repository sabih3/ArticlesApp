package com.example.newsapp.domain.repository

import androidx.lifecycle.LiveData
import com.example.newsapp.data.ArticleFavoritesDataSource
import com.example.newsapp.data.local.AppDatabase
import com.example.newsapp.domain.dto.db.Article
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticleFavoritesRepository @Inject constructor(
    private val mAppDatabase: AppDatabase
) : ArticleFavoritesDataSource {
    override fun getAllFavorites(): LiveData<List<Article>> = mAppDatabase.articleDao().getAllFavorites()
}