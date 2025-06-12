package de.janhopp.gymbro.ui.workout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.janhopp.gymbro.model.workout.WorkoutRoutine

@Composable
fun WorkoutRoutinePickerScreen(
    modifier: Modifier = Modifier,
    workoutRoutines: List<WorkoutRoutine>,
) {
    Column(modifier = modifier) {
        Text(
            text = "Workout Routines",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(vertical = 16.dp),
        )
        workoutRoutines.forEach { routine ->
            Column(
                modifier = Modifier.padding(vertical = 4.dp),
            ) {
                Text(
                    text = routine.name,
                    style = MaterialTheme.typography.titleMedium,
                )
                Text(
                    routine.description ?: "",
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
    }
}
