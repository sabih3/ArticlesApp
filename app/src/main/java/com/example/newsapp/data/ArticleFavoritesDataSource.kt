package com.example.newsapp.data

import androidx.lifecycle.LiveData
import com.example.newsapp.domain.dto.db.Article

interface ArticleFavoritesDataSource {
    fun getAllFavorites(): LiveData<List<Article>>
}