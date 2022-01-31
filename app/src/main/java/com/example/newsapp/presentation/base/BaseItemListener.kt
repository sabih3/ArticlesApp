package com.example.newsapp.presentation.base

interface BaseItemListener<T> {
    fun onItemClick(item: T)
    fun onRetryClick()
}