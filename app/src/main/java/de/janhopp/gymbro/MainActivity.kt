package de.janhopp.gymbro

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import de.janhopp.gymbro.model.workout.WorkoutRoutine
import de.janhopp.gymbro.ui.theme.GymBroTheme
import de.janhopp.gymbro.ui.workout.WorkoutRoutinePickerScreen

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val routines = listOf(
            WorkoutRoutine(0, "Beine", "Unterkörper", emptyList()),
            WorkoutRoutine(0, "Arme", "Oberkörper", emptyList()),
            WorkoutRoutine(0, "Po", "Popo", emptyList()),
        )
        setContent {
            GymBroTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                    ) {
                        WorkoutRoutinePickerScreen(routines)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GymBroTheme {
        Greeting("Android")
    }
}
