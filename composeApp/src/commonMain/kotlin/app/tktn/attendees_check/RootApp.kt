package app.tktn.attendees_check

import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.tktn.attendees_check.screen.splash.SplashScreen
import app.tktn.attendees_check.theme.AppTheme
import app.tktn.core_feature.util.LocalNavigationController
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
internal fun RootApp(
    navHostController: NavHostController = rememberNavController()
) {
    AppTheme {
        CompositionLocalProvider(
            LocalNavigationController provides navHostController
        ) {
            NavHost(
                navHostController,
                startDestination = SplashScreen
            ){
                composable<SplashScreen> {
                    SplashScreen.ComposableScreen()
                }
            }
        }
    }
}
