package app.tktn.feature_dashboard.landing

import app.tktn.core_feature.base.BaseScreenModel
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class DashboardLandingScreenModel : BaseScreenModel<DashboardLandingScreenState, DashboardLandingScreenEvent>(DashboardLandingScreenState()) {
    override fun onEvent(event: DashboardLandingScreenEvent) {
        
    }
}