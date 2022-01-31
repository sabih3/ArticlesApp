package com.example.newsapp.presentation.main.article

class ArticleItemView(private val onItemClick: () -> Unit) {
    fun onItemClick() = onItemClick.invoke()
}