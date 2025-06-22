package de.janhopp.gymbro.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import de.janhopp.gymbro.model.planning.WeightExercise
import de.janhopp.gymbro.model.exercise.kg
import de.janhopp.gymbro.model.planning.WorkoutPlan
import de.janhopp.gymbro.ui.intro.OnboardingScreen
import de.janhopp.gymbro.ui.intro.OnboardingViewModel
import de.janhopp.gymbro.ui.workout.WorkoutRoutinePickerScreen
import de.janhopp.gymbro.ui.workout.routine.WorkoutRoutineScreen
import de.janhopp.gymbro.ui.workout.routine.WorkoutRoutineViewModel
import org.koin.androidx.compose.koinViewModel

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
        val onboardingViewModel = koinViewModel<OnboardingViewModel>()
        val workoutRoutineViewModel = koinViewModel<WorkoutRoutineViewModel>()

        val isOnboardingComplete by onboardingViewModel.isOnboardingComplete.collectAsState(initial = false)
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = if (isOnboardingComplete) Destination.WorkoutRoutinePicker else Destination.Onboarding,
        ) {
            composable<Destination.Onboarding> {
                OnboardingScreen(onboardingViewModel)
            }
            composable<Destination.WorkoutRoutinePicker> {
                val workoutRoutines by workoutRoutineViewModel.getWorkoutRoutines().collectAsState(emptyList())

                WorkoutRoutinePickerScreen(
                    workoutPlans = workoutRoutines,
                    onRoutineSelected = { routine ->
                        navController.navigate(
                            Destination.WorkoutRoutineOverview(routine.id)
                        )
                    }
                )
            }
            composable<Destination.WorkoutRoutineOverview> { backStackEntry ->
                val args = backStackEntry.toRoute<Destination.WorkoutRoutineOverview>()
                WorkoutRoutineScreen(
                    routineId = args.routineId,
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
