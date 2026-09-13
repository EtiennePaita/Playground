package com.paita.playground.ui.nav

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

/**
 *
 * This file centralize all the navigation destinations by
 * overriding [NavKey]
 *
 */

/**
 * NavKey for SplashScreen destination
 */
@Serializable
data object Splash : NavKey

/**
 * NavKey for HomeScreen destination
 */
@Serializable
data object Home : NavKey

