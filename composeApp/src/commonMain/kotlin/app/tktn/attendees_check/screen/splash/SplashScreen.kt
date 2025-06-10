package app.tktn.attendees_check.screen.splash

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import app.tktn.core_feature.base.BaseScreen
import kotlinx.serialization.Serializable

@Serializable
object SplashScreen : BaseScreen() {
    override val pageName: String?
        get() = this::class.simpleName

    @Composable
    override fun ComposeContent(navHostController: NavHostController) {

    }
}

