package com.paita.playground.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paita.playground.R
import com.paita.playground.ui.theme.DarkGrey
import com.paita.playground.ui.theme.Green
import com.paita.playground.ui.theme.LightBlack
import com.paita.playground.ui.theme.PlaygroundTheme

@Composable
fun AppTopBar(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .align(Alignment.Center),
            horizontalAlignment = Alignment.End
        ) {
            Text(
                stringResource(R.string.app_name),
                style = MaterialTheme.typography.displayLarge.copy(
                    shadow = Shadow(
                        color = DarkGrey.copy(alpha = 0.7f),
                        offset = Offset(5.0f, 25.0f),
                        blurRadius = 20f
                    ),
                    color = DarkGrey
                ),
            )
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

@Preview
@Composable
private fun AppTopBar_Preview() {
    PlaygroundTheme {
        AppTopBar(Modifier.background(Color.White))
    }
}