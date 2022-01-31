package com.example.newsapp.presentation.base

import androidx.lifecycle.ViewModel
import com.example.newsapp.utils.SingleLiveEvent

abstract class BaseViewModel : ViewModel() {
    val isLoading: SingleLiveEvent<Boolean> = SingleLiveEvent()
    val showToast: SingleLiveEvent<String> = SingleLiveEvent()
}