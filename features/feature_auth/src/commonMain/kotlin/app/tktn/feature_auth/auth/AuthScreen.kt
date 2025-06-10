package app.tktn.feature_auth.auth

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import app.tktn.core_feature.base.BaseScreen
import app.tktn.core_feature.base.BaseScreenModel
import kotlinx.serialization.Serializable
import org.koin.android.annotation.KoinViewModel

@Serializable
object AuthScreen : BaseScreen() {
    override val pageName: String?
        get() = this::class.simpleName

    @Composable
    override fun ComposeContent(navHostController: NavHostController) {

    }
}



