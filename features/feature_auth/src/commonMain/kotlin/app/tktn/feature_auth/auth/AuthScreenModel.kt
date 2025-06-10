package app.tktn.feature_auth.auth

import app.tktn.core_feature.base.BaseScreenModel
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class AuthScreenModel : BaseScreenModel<AuthScreenState, AuthScreenEvent>(AuthScreenState()) {
    override fun onEvent(event: AuthScreenEvent) {

    }
}