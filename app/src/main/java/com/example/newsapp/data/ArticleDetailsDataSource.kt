package com.example.newsapp.data

import com.example.newsapp.domain.dto.Result
import com.example.newsapp.domain.dto.db.Article

interface ArticleDetailsDataSource {
    suspend fun insert(article: Article)
    suspend fun delete(article: Article)
    suspend fun getFavoriteById(id: Long): Result<Article>
}