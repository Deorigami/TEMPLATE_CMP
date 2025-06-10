package app.tktn.attendees_check.screen.splash

import kotlinx.serialization.Serializable

@Serializable
object SplashScreen : BaseScreen() {
    override val pageName: String?
        get() = this::class.simpleName

    @Composable
    override fun ComposeContent(navHostController: NavHostController) {

    }
}

@KoinViewModel
class SplashScreenModel : BaseScreenModel<SplashScreenState, SplashScreenEvent>(SplashScreenState()) {
    override fun onEvent(event: SplashScreenEvent) {

    }
}

data class SplashScreenState(
    val isLoading: Boolean = false
)

sealed interface SplashScreenEvent {

}