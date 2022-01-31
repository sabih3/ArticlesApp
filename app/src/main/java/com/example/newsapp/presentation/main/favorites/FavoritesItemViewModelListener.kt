package com.example.newsapp.presentation.main.favorites

import com.example.newsapp.domain.dto.db.Article
import com.example.newsapp.presentation.base.BaseItemListener

interface FavoritesItemViewModelListener : BaseItemListener<Article> {
    override fun onRetryClick() {}
}