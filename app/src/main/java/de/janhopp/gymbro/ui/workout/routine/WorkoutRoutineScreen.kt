package de.janhopp.gymbro.ui.workout.routine

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.janhopp.gymbro.model.exercise.WeightExercise
import de.janhopp.gymbro.model.workout.WorkoutRoutine
import org.koin.androidx.compose.koinViewModel

@Composable
fun WorkoutRoutineScreen(
    modifier: Modifier = Modifier,
    routineId: Int,
    viewModel: WorkoutRoutineViewModel = koinViewModel(),
) {
    val routine by viewModel.getWorkoutRoutine(routineId).collectAsState(initial = WorkoutRoutine(0, "", null, null))
    val exercises by viewModel.getWorkoutRoutineExercises(routineId).collectAsState(initial = emptyList())
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        routine.emoji?.let {
            Text(
                text = it,
                modifier = Modifier
                    .padding(top = 48.dp),
                style = MaterialTheme.typography.displayLarge,
            )
        }
        Text(
            text = routine.name,
            modifier = Modifier
                .padding(top = 32.dp, bottom = 8.dp),
            style = MaterialTheme.typography.titleLarge,
        )
        routine.description?.let { description ->
            Text(
                text = description,
                modifier = Modifier
                    .padding(bottom = 8.dp),
                style = MaterialTheme.typography.bodyMedium,
            )
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = if (exercises.isEmpty()) Arrangement.Center else Arrangement.Top
        ) {
            if (exercises.isEmpty()) {
                Button(
                    onClick = { /* TODO */ },
                ) {
                    Text(text = "Add exercises")
                }
            } else {
                exercises.forEach { exercise ->
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
    }
}
