package com.loc.newsapp.presentation.onboarding

import androidx.annotation.DrawableRes
import com.loc.newsapp.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        title = "This is dummy title 1",
        description = "This is a dummy description text for the onboarding screens",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "This is dummy title 2",
        description = "This is a dummy description text for the onboarding screens",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "This is dummy title 1",
        description = "This is a dummy description text for the onboarding screens",
        image = R.drawable.onboarding3
    )
)
