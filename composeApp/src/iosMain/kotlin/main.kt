import androidx.compose.ui.window.ComposeUIViewController
import app.tktn.attendees_check.RootApp
import org.koin.core.context.startKoin
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController {
    startKoin {
        modules(listOf())
    }
    return ComposeUIViewController { RootApp() }
}
