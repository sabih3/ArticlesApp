package com.example.newsapp.presentation.main.favorites

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FavoritesFragmentProvider {
    @ContributesAndroidInjector
    abstract fun provideFavoritesFragmentFactory(): FavoritesFragment
}