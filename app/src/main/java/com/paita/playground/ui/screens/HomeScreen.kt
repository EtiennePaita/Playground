package com.paita.playground.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.paita.playground.ui.components.AppTopBar
import com.paita.playground.ui.theme.PlaygroundTheme
import com.paita.playground.ui.theme.playgroundBackground

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = modifier
                .playgroundBackground()
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            AppTopBar()
        }
    }

}

@Preview
@Composable
private fun HomeScreen_Preview() {
    PlaygroundTheme {
        HomeScreen(
            modifier = Modifier.playgroundBackground()
        )
    }
}