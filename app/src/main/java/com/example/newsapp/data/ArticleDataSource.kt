package com.example.newsapp.data

import com.example.newsapp.domain.dto.Result
import com.example.newsapp.domain.dto.api.ArticlesResponse

interface ArticleDataSource {
    suspend fun getArticles(period: Int): Result<ArticlesResponse>
}