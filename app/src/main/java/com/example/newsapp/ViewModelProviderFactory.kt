package com.example.newsapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory
import com.example.newsapp.data.ArticleDataSource
import com.example.newsapp.data.ArticleDetailsDataSource
import com.example.newsapp.data.ArticleFavoritesDataSource
import com.example.newsapp.presentation.main.MainViewModel
import com.example.newsapp.presentation.main.article.ArticleViewModel
import com.example.newsapp.presentation.main.article_details.ArticleDetailsViewModel
import com.example.newsapp.presentation.main.favorites.FavoritesViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ViewModelProviderFactory @Inject constructor(
    private val articleDataSource: ArticleDataSource,
    private val articleDetailsDataSource: ArticleDetailsDataSource,
    private val articleFavoritesDataSource: ArticleFavoritesDataSource
) : NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel() as T
            }
            modelClass.isAssignableFrom(ArticleViewModel::class.java) -> {
                ArticleViewModel(articleDataSource) as T
            }
            modelClass.isAssignableFrom(ArticleDetailsViewModel::class.java) -> {
                ArticleDetailsViewModel(articleDetailsDataSource) as T
            }
            modelClass.isAssignableFrom(FavoritesViewModel::class.java) -> {
                FavoritesViewModel(articleFavoritesDataSource) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}