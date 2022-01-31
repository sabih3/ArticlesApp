package com.example.newsapp.presentation.main.article

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ArticleFragmentProvider {
    @ContributesAndroidInjector
    abstract fun provideArticleFragmentFactory(): ArticleFragment
}