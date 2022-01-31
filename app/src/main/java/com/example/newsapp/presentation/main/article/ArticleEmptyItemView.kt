package com.example.newsapp.presentation.main.article

class ArticleEmptyItemView(private val onRetry: () -> Unit) {
    fun onRetryClick() = onRetry.invoke()
}