package com.loc.newsapp.presentation.news_navigator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.loc.newsapp.R
import com.loc.newsapp.presentation.news_navigator.components.BottomNavigationItem


@Composable
fun NewsNavigator() {

    val bottomNavigationItems = remember {
        listOf(
            BottomNavigationItem(icon = R.drawable.ic_home, text = "Home"),
            BottomNavigationItem(icon = R.drawable.ic_search, text = "Search"),
            BottomNavigationItem(icon = R.drawable.ic_bookmark, text = "Bookmark")
        )
    }


}


