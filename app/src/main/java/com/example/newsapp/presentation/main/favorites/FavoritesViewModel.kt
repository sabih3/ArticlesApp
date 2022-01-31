package com.example.newsapp.presentation.main.favorites

import androidx.lifecycle.LiveData
import com.example.newsapp.data.ArticleFavoritesDataSource
import com.example.newsapp.domain.dto.db.Article
import com.example.newsapp.presentation.base.BaseViewModel

class FavoritesViewModel(
    articleFavoritesDataSource: ArticleFavoritesDataSource
) : BaseViewModel() {
    val articlesLiveData: LiveData<List<Article>> = articleFavoritesDataSource.getAllFavorites()
}