package de.janhopp.gymbro.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import de.janhopp.gymbro.model.exercise.WeightExercise
import de.janhopp.gymbro.model.exercise.kg
import de.janhopp.gymbro.model.workout.WorkoutRoutine
import de.janhopp.gymbro.ui.workout.WorkoutRoutinePickerScreen
import de.janhopp.gymbro.ui.workout.routine.WorkoutRoutineScreen

@Composable
fun NavHostScreen() {
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            @OptIn(ExperimentalMaterial3Api::class)
            TopAppBar(
                title = { Text(text = "Gym Bro") },
            )
        },
    ) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = Destination.WorkoutRoutinePicker
        ) {
            composable<Destination.WorkoutRoutinePicker> {
                WorkoutRoutinePickerScreen(
                    workoutRoutines = routines,
                    onRoutineSelected = { routine ->
                        navController.navigate(
                            Destination.WorkoutRoutineOverview(routine.id)
                        )
                    }
                )
            }
            composable<Destination.WorkoutRoutineOverview> { backStackEntry ->
                val args = backStackEntry.toRoute<Destination.WorkoutRoutineOverview>()
                val routine = routines.first { it.id == args.routineId }
                WorkoutRoutineScreen(
                    routine = routine,
                )
            }
        }
    }
}

operator fun <T> List<T>.times(n: Int): List<T> = buildList {
    repeat(n) {
        addAll(elements = this@times)
    }
}

private val exercises = listOf(
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
)

private val routines = listOf(
    WorkoutRoutine(0, "Beine", "Unterkörper", "\uD83E\uDDB5", exercises),
    WorkoutRoutine(1, "Arme", "Oberkörper", "\uD83D\uDCAA", emptyList()),
    WorkoutRoutine(2, "Po", "Popo", "\uD83C\uDF51", emptyList()),
    WorkoutRoutine(3, "Cardio", "Lässt jedes Herz höher schlagen", "❤\uFE0F", emptyList()),
    WorkoutRoutine(4, "Wilder Mix", "Gewichte, Gewichte, Gewichte", null, emptyList()),
) * 3

