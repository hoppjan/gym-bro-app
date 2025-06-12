package de.janhopp.gymbro.ui.workout.routine

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.janhopp.gymbro.model.exercise.WeightExercise
import de.janhopp.gymbro.model.workout.WorkoutRoutine

@Composable
fun WorkoutRoutineScreen(
    modifier: Modifier = Modifier,
    routine: WorkoutRoutine,
) {
    Column(
        modifier = modifier,
    ) {
        routine.emoji?.let {
            Text(
                text = it,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 48.dp),
                style = MaterialTheme.typography.displayLarge,
            )
        }
        Text(
            text = routine.name,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 32.dp, bottom = 8.dp),
            style = MaterialTheme.typography.titleLarge,
        )
        routine.description?.let { description ->
            Text(
                text = description,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 8.dp),
                style = MaterialTheme.typography.bodyMedium,
            )
        }
        routine.exercises.forEach { exercise ->
            ListItem(
                headlineContent = {
                    Text(text = exercise.name)
                },
                supportingContent = {
                    Column {
                        if (exercise is WeightExercise) {
                            Text(
                                text = buildString {
                                    append(exercise.sets)
                                    append(" x ")
                                    append(exercise.reps)
                                    append(" @ ")
                                    append(exercise.weight.value)
                                    append(" ")
                                    append(exercise.weight.unit)
                                }
                            )
                        }
                        Text(text = exercise.description ?: "")
                    }
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