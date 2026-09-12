package com.paita.playground.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paita.playground.ui.components.AppTopBar
import com.paita.playground.ui.theme.PlaygroundTheme
import com.paita.playground.ui.theme.playgroundBackground


@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    navigateToHome : () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .clickable {
                navigateToHome()
            }
    ) {
        AppTopBar(Modifier.align(Alignment.Center))

        Text(
            "Aller à la page d'accueil",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 100.dp)
        )
    }
}

@Preview
@Composable
private fun SplashScreen_Preview() {
    PlaygroundTheme {
        SplashScreen(
            modifier = Modifier.playgroundBackground(),
            navigateToHome = {}
        )
    }
}