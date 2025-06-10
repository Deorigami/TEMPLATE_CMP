package app.tktn.attendees_check

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import app.tktn.attendees_check.screen.splash.SplashScreen
import attendees_check_app.composeapp.generated.resources.*
import app.tktn.attendees_check.theme.AppTheme
import app.tktn.attendees_check.theme.LocalThemeIsDark
import app.tktn.core_feature.util.LocalNavigationController
import kotlinx.coroutines.isActive
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
internal fun App(
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

            }
        }
    }
}
