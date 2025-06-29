package de.janhopp.gymbro.ui.workout.planning

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.janhopp.gymbro.model.planning.BodyWeightExercise
import de.janhopp.gymbro.model.planning.PlannedExercise
import de.janhopp.gymbro.model.planning.WeightExercise
import de.janhopp.gymbro.model.planning.WorkoutPlan
import org.koin.androidx.compose.koinViewModel
import sh.calvin.reorderable.ReorderableColumn

@Composable
fun WorkoutPlanScreen(
    modifier: Modifier = Modifier,
    workoutPlanId: Int,
    viewModel: WorkoutPlanViewModel = koinViewModel(),
) {
    val workoutPlan by viewModel.getWorkoutPlan(workoutPlanId)
        .collectAsState(initial = WorkoutPlan(0, "", null, null))
    val exercises by viewModel.getWorkoutPlanExercises(workoutPlanId)
        .collectAsState(initial = emptyList())
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        workoutPlan.icon?.let {
            Text(
                text = it,
                modifier = Modifier
                    .padding(top = 48.dp),
                style = MaterialTheme.typography.displayLarge,
            )
        }
        Text(
            text = workoutPlan.name,
            modifier = Modifier
                .padding(top = 32.dp, bottom = 8.dp),
            style = MaterialTheme.typography.titleLarge,
        )
        workoutPlan.description?.let { description ->
            Text(
                text = description,
                modifier = Modifier
                    .padding(bottom = 8.dp),
                style = MaterialTheme.typography.bodyMedium,
            )
        }
        ReorderableColumn(
            list = exercises,
            onSettle = { fromIndex, toIndex -> /* TODO */},
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = if (exercises.isEmpty()) Arrangement.Center else Arrangement.Top
        ) { index: Int, exercise: PlannedExercise, isDragging: Boolean ->
            if (exercises.isEmpty()) {
                Button(
                    onClick = { viewModel.addExercises() },
                ) {
                    Text(text = "Add exercises")
                }
            } else {
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
                            } else if (exercise is BodyWeightExercise) {
                                Text(text = "${exercise.sets} x ${exercise.reps}")
                            }
                            exercise.description?.let { Text(text = it) }
                        }
                    },
                    leadingContent = {
                        Icon(
                            modifier = Modifier.draggableHandle(),
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Reorder",
                        )
                    }
                )
            }
        }
    }
}
