package com.paita.playground.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import com.paita.playground.R
import com.paita.playground.ui.LocalSharedTransitionScope
import com.paita.playground.ui.base.preview.AnimationPreviewSetup
import com.paita.playground.ui.theme.DarkGrey
import com.paita.playground.ui.theme.Green
import com.paita.playground.ui.theme.LightBlack
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds


@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    animatedVisibilityScope: AnimatedVisibilityScope,
    navigateToHome : () -> Unit,
) {
    var startAnimation by remember { mutableStateOf(false) }
    var isSubtitleVisible by remember { mutableStateOf(false) }

    val progress by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 700),
        finishedListener = {
            isSubtitleVisible = true
        }
    )

    LaunchedEffect(Unit) {
        delay(300.milliseconds)
        startAnimation = true
    }

    LaunchedEffect(isSubtitleVisible) {
        if (isSubtitleVisible) {
            delay(1500.milliseconds)
            navigateToHome()
        }
    }

    with(LocalSharedTransitionScope.current) {
        val topBarSharedState = rememberSharedContentState(key = "top-app-bar-title")
        Box(
            modifier = modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .sharedElement(
                        topBarSharedState,
                        animatedVisibilityScope
                    )
                    .defaultMinSize(minHeight = 70.dp)
                    .align(Alignment.Center),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge.copy(
                        shadow = Shadow(
                            color = DarkGrey.copy(
                                alpha = lerp(0f,0.7f,progress) //if (progress == 1f) 0.7f else 0f
                            ),
                            offset = Offset(5.0f, 25.0f),
                            blurRadius = 20f
                        ),
                        color = DarkGrey.copy(
                            alpha = progress
                        ),
                        fontSize = lerp(18.sp, 36.sp, progress),
                    ),

                )
                AnimatedVisibility(
                    visible = isSubtitleVisible,
                    enter = slideInHorizontally(
                        animationSpec = tween(800)
                    ) { x -> x + 10 } + fadeIn(animationSpec = tween(800)),
                    exit = slideOutHorizontally { x -> x + 10 } + fadeOut(),
                ) {
                    Text(
                        "by Etienne Païta",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = Green,
                            shadow = Shadow(
                                color = LightBlack.copy(alpha = 0.3f),
                                offset = Offset(5.0f, 20.0f),
                                blurRadius = 8f
                            )
                        )
                    )
                }
            }
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