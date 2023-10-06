package com.loc.newsapp.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.loc.newsapp.presentation.common.NewsButton
import com.loc.newsapp.presentation.common.NewsTextButton
import com.loc.newsapp.presentation.onboarding.Dimens.MediumPadding1
import com.loc.newsapp.presentation.onboarding.Dimens.PageIndicatorWidth
import com.loc.newsapp.presentation.onboarding.components.OnboardingPage
import com.loc.newsapp.presentation.onboarding.components.PageIndicator
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier,
    event: (OnboardingEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        val pageState = rememberPagerState(initialPage = 0) {
            pages.size
        }
        val buttonState = remember{
            derivedStateOf {
                when(pageState.currentPage) {
                    0 -> listOf("", "Next")
                    1 -> listOf("Back", "Next")
                    2 -> listOf("Back", "Get Started")
                    else -> listOf("", "")
                }
            }
        }
        HorizontalPager(state = pageState) {index ->
            OnboardingPage(page = pages[index])
        }
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MediumPadding1)
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PageIndicator(
                modifier = Modifier.width(PageIndicatorWidth),
                pageSize = pages.size,
                selectedPage = pageState.currentPage
            )


            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val scope = rememberCoroutineScope()
                if (buttonState.value[0].isNotEmpty()) {
                    NewsTextButton(
                        text = buttonState.value[0],
                        onClick = {
                            scope.launch {
                                pageState.animateScrollToPage(page = pageState.currentPage - 1)
                            }
                        }
                    )
                }
                NewsButton(
                    text = buttonState.value[1],
                    onClick = {
                        scope.launch {
                            if (pageState.currentPage == 2) {
                                //To do navigate to home screen
                                event(OnboardingEvent.SaveAppEntry)
                            } else {
                                pageState.animateScrollToPage(page = pageState.currentPage + 1)
                            }
                        }
                    }
                )

            }

        }
        Spacer(modifier = Modifier.weight(0.5f)) //placed after the column
    }
}