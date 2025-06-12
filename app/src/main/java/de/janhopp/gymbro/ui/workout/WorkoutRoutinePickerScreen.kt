package de.janhopp.gymbro.ui.workout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ListItem
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
            modifier = Modifier.padding(all = 16.dp),
        )
        workoutRoutines.forEach { routine ->
            ListItem(
                headlineContent = {
                    Text(text = routine.name)
                },
                supportingContent = {
                    Text(text = routine.description ?: "")
                },
                leadingContent = {
                    routine.emoji?.let { emoji ->
                        Text(text = emoji)
                    }
                },
            )
        }
    }
}
