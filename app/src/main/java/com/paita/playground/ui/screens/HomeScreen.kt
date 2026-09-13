package com.paita.playground.ui.screens

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.paita.playground.ui.LocalSharedTransitionScope
import com.paita.playground.ui.base.preview.AnimationPreviewSetup
import com.paita.playground.ui.components.AppTopBar

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    animatedVisibilityScope: AnimatedVisibilityScope,
) {

    with(LocalSharedTransitionScope.current) {
        val topBarSharedState = rememberSharedContentState(key = "top-app-bar-title")
        Column(
            modifier = modifier
                .fillMaxSize()
        ) {
            AppTopBar(
                Modifier.sharedElement(
                    topBarSharedState,
                    animatedVisibilityScope
                )
            )
        }
    }

}

@Preview
@Composable
private fun HomeScreen_Preview() {
    AnimationPreviewSetup {
        HomeScreen(
            animatedVisibilityScope = this
        )
    }
}