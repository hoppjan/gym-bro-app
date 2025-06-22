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
import de.janhopp.gymbro.ui.intro.OnboardingScreen
import de.janhopp.gymbro.ui.intro.OnboardingViewModel
import de.janhopp.gymbro.ui.workout.WorkoutPlanPickerScreen
import de.janhopp.gymbro.ui.workout.planning.WorkoutPlanScreen
import de.janhopp.gymbro.ui.workout.planning.WorkoutPlanViewModel
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
        val workoutPlanViewModel = koinViewModel<WorkoutPlanViewModel>()

        val isOnboardingComplete by onboardingViewModel.isOnboardingComplete.collectAsState(initial = true)
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = if (isOnboardingComplete) Destination.WorkoutPlanPicker else Destination.Onboarding,
        ) {
            composable<Destination.Onboarding> {
                OnboardingScreen(onboardingViewModel, { navController.navigate(it) })
            }
            composable<Destination.WorkoutPlanPicker> {
                val workoutPlans by workoutPlanViewModel.getWorkoutPlans().collectAsState(emptyList())

                WorkoutPlanPickerScreen(
                    workoutPlans = workoutPlans,
                    onWorkoutPlanSelected = { workoutPlan ->
                        navController.navigate(
                            Destination.WorkoutPlanOverview(workoutPlan.id)
                        )
                    }
                )
            }
            composable<Destination.WorkoutPlanOverview> { backStackEntry ->
                val args = backStackEntry.toRoute<Destination.WorkoutPlanOverview>()
                WorkoutPlanScreen(
                    workoutPlanId = args.workoutPlanId,
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
