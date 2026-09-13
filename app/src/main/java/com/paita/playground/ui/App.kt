package com.paita.playground.ui

import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf

/**
 * Global Shared Transition Scope.
 * It is exposed through local composition.
 */
val LocalSharedTransitionScope = compositionLocalOf<SharedTransitionScope> {
    error("No SharedTransitionScope provided")
}

/**
 * Entry point of our App.
 *
 * Sets up the shared transition and provides it through the
 * all app.
 *
 * @param content Composable
 */
@Composable
fun App(
    content: @Composable () -> Unit
) {
    SharedTransitionLayout {
        CompositionLocalProvider(
            LocalSharedTransitionScope provides this,
            content = content
        )
    }
}