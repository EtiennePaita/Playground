package com.paita.playground.ui.base.preview

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import com.paita.playground.ui.LocalSharedTransitionScope
import com.paita.playground.ui.theme.PlaygroundTheme
import com.paita.playground.ui.theme.playgroundBackground

/**
 * Basic setup to Preview a Composable with Shared transitions
 * or animation
 *
 * @param previewContent The content to preview within the scope [AnimatedVisibilityScope]
 */
@Composable
fun AnimationPreviewSetup(
    previewContent: @Composable AnimatedVisibilityScope.() -> Unit
) {
    PlaygroundTheme {
        SharedTransitionLayout(
            modifier = Modifier.playgroundBackground()
        ) {
            CompositionLocalProvider(
                LocalSharedTransitionScope provides this
            ) {
                AnimatedVisibility(
                    visible = true,
                    content = previewContent
                )
            }
        }
    }
}