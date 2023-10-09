package com.loc.newsapp.domain.usecases.news


//This is the wrapper class for the use cases

data class NewsUseCases(
    val getNews: GetNews,
    val searchNews: SearchNews
)
