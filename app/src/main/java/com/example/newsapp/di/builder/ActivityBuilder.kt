package com.example.newsapp.di.builder

import com.example.newsapp.presentation.main.MainActivity
import com.example.newsapp.presentation.main.article.ArticleFragmentProvider
import com.example.newsapp.presentation.main.article_details.ArticleDetailsFragmentProvider
import com.example.newsapp.presentation.main.favorites.FavoritesFragmentProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [ArticleFragmentProvider::class, ArticleDetailsFragmentProvider::class, FavoritesFragmentProvider::class])
    abstract fun bindMainActivity(): MainActivity
}