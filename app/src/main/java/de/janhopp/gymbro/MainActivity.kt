package de.janhopp.gymbro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import de.janhopp.gymbro.ui.navigation.NavHostScreen
import de.janhopp.gymbro.ui.theme.GymBroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GymBroTheme {
                NavHostScreen()
            }
        }
    }
}
