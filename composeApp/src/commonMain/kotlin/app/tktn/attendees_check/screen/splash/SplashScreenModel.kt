package app.tktn.attendees_check.screen.splash

import app.tktn.core_feature.base.BaseScreenModel
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class SplashScreenModel : BaseScreenModel<SplashScreenState, SplashScreenEvent>(SplashScreenState()) {
    override fun onEvent(event: SplashScreenEvent) {

    }
}