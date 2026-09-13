package com.paita.playground.ui.screens

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.paita.playground.ui.LocalSharedTransitionScope
import com.paita.playground.ui.base.preview.AnimationPreviewSetup
import com.paita.playground.ui.components.AppTopBar


@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    animatedVisibilityScope: AnimatedVisibilityScope,
    navigateToHome : () -> Unit,
) {

    with(LocalSharedTransitionScope.current) {
        val topBarSharedState = rememberSharedContentState(key = "top-app-bar-title")
        Box(
            modifier = modifier
                .fillMaxSize()
                .clickable {
                    navigateToHome()
                }
        ) {
            AppTopBar(
                Modifier
                    .align(Alignment.Center)
                    .sharedElement(
                        topBarSharedState,
                        animatedVisibilityScope
                    )

            )
        }
    }
}

@Preview
@Composable
private fun SplashScreen_Preview() {
    AnimationPreviewSetup {
        SplashScreen(
            animatedVisibilityScope = this,
            navigateToHome = {}
        )
    }
}