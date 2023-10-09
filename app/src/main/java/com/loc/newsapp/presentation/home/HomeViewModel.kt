package com.loc.newsapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.loc.newsapp.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getNewsUseCase: NewsUseCases
) : ViewModel() {


    val news = getNewsUseCase.getNews(
        sources = listOf("bbc-news", "al-jazeera english", "abc-news")
    ).cachedIn(viewModelScope)

}