import androidx.compose.ui.window.ComposeUIViewController
import app.tktn.attendees_check.App
import org.koin.core.context.startKoin
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController {
    startKoin {
        modules(listOf())
    }
    return ComposeUIViewController { App() }
}
