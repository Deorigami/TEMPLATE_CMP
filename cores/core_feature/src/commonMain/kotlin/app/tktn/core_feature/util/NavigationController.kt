package app.tktn.core_feature.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController

val LocalNavigationController = compositionLocalOf<NavHostController> { error("Navigation Controller not found!!") }
//
//@Composable
//expect fun BackHandler(enabled: Boolean = true, onBack: () -> Unit)