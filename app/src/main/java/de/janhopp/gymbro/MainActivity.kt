package de.janhopp.gymbro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import de.janhopp.gymbro.model.exercise.WeightExercise
import de.janhopp.gymbro.model.exercise.kg
import de.janhopp.gymbro.model.workout.WorkoutRoutine
import de.janhopp.gymbro.ui.theme.GymBroTheme
import de.janhopp.gymbro.ui.workout.WorkoutRoutinePickerScreen
import de.janhopp.gymbro.ui.workout.routine.WorkoutRoutineScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GymBroTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    WorkoutRoutineScreen(
                        modifier = Modifier.padding(innerPadding),
                        routine = routine,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GymBroTheme {
        WorkoutRoutinePickerScreen(
            modifier = Modifier.fillMaxSize(),
            workoutRoutines = routines,
        )
    }
}

private val routines = listOf(
    WorkoutRoutine(0, "Beine", "Unterkörper", "\uD83E\uDDB5", emptyList()),
    WorkoutRoutine(1, "Arme", "Oberkörper", "\uD83D\uDCAA", emptyList()),
    WorkoutRoutine(2, "Po", "Popo", "\uD83C\uDF51", emptyList()),
)

private val routine = WorkoutRoutine(
    id = 0,
    name = "Beine",
    description = "Unterkörper",
    emoji = "\uD83E\uDDB5",
    exercises = listOf(
        WeightExercise(
            id = 0,
            name = "Leg Press",
            description = "Wie Kniebeugen im Autsch-Modus",
            equipment = "Leg press",
            muscleGroup = "Beine",
            sets = 3,
            reps = 12,
            weight = 80.kg,
        ),
        WeightExercise(
            id = 1,
            name = "Leg Press 2",
            description = "Wie Kniebeugen im Autsch-Modus 2",
            equipment = "Wieder Leg press",
            muscleGroup = "Beine",
            sets = 3,
            reps = 12,
            weight = 120.kg,
        ),
    ),
)