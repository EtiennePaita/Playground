package com.paita.playground.ui.nav

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.paita.playground.ui.screens.HomeScreen
import com.paita.playground.ui.screens.SplashScreen
import com.paita.playground.ui.theme.playgroundBackground

@Composable
fun AppNavDisplay() {
    val backStack = rememberNavBackStack(Splash)

    LaunchedEffect(backStack.size) {
        backStack.log()
    }

    fun navigateTo(
        key: NavKey,
        strategy: NavStrategy = NavStrategy.Default,
    ) {
        strategy.navigate(backStack, key)
    }

    NavDisplay(
        modifier = Modifier
            .fillMaxSize()
            .playgroundBackground(),
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            when (key) {
                is Splash -> NavEntry(key) {
                    SplashScreen(
                        navigateToHome = {
                            navigateTo(
                                Home,
                                strategy = NavStrategy.PopUpTo(
                                    Splash,
                                    true
                                )
                            )
                        }
                    )
                }
                is Home -> NavEntry(key) {
                    HomeScreen()
                }
                else -> NavEntry(object : NavKey {}) { Text("Unknown route") }
            }
        }
    )


}


sealed interface NavStrategy {

    /**
     * Method that control the navigation to a destination by
     * monitoring the backstack.
     *
     * @param backStack of the current navigation
     * @param destinationKey to navigate to
     */
    fun navigate(backStack: NavBackStack<NavKey>, destinationKey: NavKey)

    /**
     * Default navigation strategy.
     *
     * Add the destination key to the navBackStack.
     */
    data object Default : NavStrategy {
        override fun navigate(
            backStack: NavBackStack<NavKey>,
            destinationKey: NavKey
        ) {
            backStack.add(destinationKey)
        }
    }

    /**
     * SingleTop navigation strategy.
     *
     * Prevents a new instance of a destination key from being created
     * if it is already sitting at the top of the back stack.
     */
    data object SingleTop : NavStrategy {
        override fun navigate(
            backStack: NavBackStack<NavKey>,
            destinationKey: NavKey
        ) {
            if (backStack.last() != destinationKey) {
                backStack.add(destinationKey)
            }
        }
    }

    /**
     * PopUpTo navigation strategy.
     *
     * Removes screens up to a certain destination key before pushing the new one.
     *
     * @property key The NavKey to popup to.
     * @property included If the [key] must also be removed.
     */
    class PopUpTo(
        private val key: NavKey,
        private val included: Boolean,
        private val singleTop: Boolean = true,
    ) : NavStrategy {
        override fun navigate(
            backStack: NavBackStack<NavKey>,
            destinationKey: NavKey
        ) {
            if (singleTop && backStack.last() == destinationKey) return

            val keyIndex = backStack.indexOfFirst { it == key }
            val lastIndex = backStack.lastIndex

            if (keyIndex != -1) {
                // pop back stack navKeys
                val downRange = if (!included && keyIndex < lastIndex) keyIndex + 1 else keyIndex
                for (i in lastIndex downTo downRange) {
                    backStack.removeAt(i)
                }
            }

            // push destination key
            backStack.add(destinationKey)
        }
    }
}

private fun NavBackStack<NavKey>.log() {
    var backStackString = "["
    this.forEach { key ->
        backStackString += "${key.javaClass.simpleName}, "
    }
    backStackString += "]"

    Log.d("[BackStack]",backStackString)
}
