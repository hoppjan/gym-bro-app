package de.janhopp.gymbro.ui.workout

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.janhopp.gymbro.model.workout.WorkoutRoutine
import de.janhopp.gymbro.ui.workout.routine.WorkoutRoutineViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun WorkoutRoutinePickerScreen(
    modifier: Modifier = Modifier,
    workoutRoutines: List<WorkoutRoutine>,
    onRoutineSelected: (WorkoutRoutine) -> Unit = {},
    viewModel: WorkoutRoutineViewModel = koinViewModel(),
) {
    Box(
        modifier = modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState()),
        ) {
            workoutRoutines.forEach { routine ->
                ListItem(
                    modifier = Modifier.clickable { onRoutineSelected(routine) },
                    headlineContent = {
                        Text(text = routine.name)
                    },
                    supportingContent = {
                        Text(text = routine.description ?: "")
                    },
                    leadingContent = {
                        Text(
                            text = routine.emoji ?: "",
                            modifier = Modifier.width(20.dp)
                        )
                    },
                )
            }
            Spacer(modifier = Modifier.height(height = 64.dp))
        }
        ExtendedFloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
            onClick = { viewModel.addWorkoutRoutines() },
            icon = { Icon(Icons.Filled.Add, contentDescription = "Add routines") },
            text = { Text(text = "Add routines") },
        )
    }
}
