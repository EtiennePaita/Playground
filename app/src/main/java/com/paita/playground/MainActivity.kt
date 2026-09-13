package com.paita.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.paita.playground.ui.App
import com.paita.playground.ui.nav.MainNavDisplay
import com.paita.playground.ui.theme.PlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            PlaygroundTheme {
                App {
                    MainNavDisplay()
                }
            }
        }
    }
}