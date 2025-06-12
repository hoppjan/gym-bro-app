package de.janhopp.gymbro.ui.workout.routine

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import de.janhopp.gymbro.model.workout.WorkoutRoutine

@Composable
fun WorkoutRoutineScreen(
    modifier: Modifier = Modifier,
    routine: WorkoutRoutine,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = routine.name,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.titleLarge,
        )
        routine.description?.let { description ->
            Text(
                text = description,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.bodyMedium,
            )
        }
        routine.exercises.forEach { exercise ->
            ListItem(
                headlineContent = {
                    Text(text = exercise.name)
                },
                supportingContent = {
                    Text(text = exercise.description ?: "")
                },
                leadingContent = {
                    routine.emoji?.let { emoji ->
                        Text(text = emoji)
                    }
                }
            )
        }
    }
}