package com.example.newsapp.presentation.main.favorites

class FavoritesItemView(private val action: () -> Unit) {
    fun onItemClick() = action.invoke()
}