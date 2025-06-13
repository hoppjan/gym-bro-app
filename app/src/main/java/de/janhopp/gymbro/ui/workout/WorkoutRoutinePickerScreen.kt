package de.janhopp.gymbro.ui.workout

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.janhopp.gymbro.model.workout.WorkoutRoutine

@Composable
fun WorkoutRoutinePickerScreen(
    modifier: Modifier = Modifier,
    workoutRoutines: List<WorkoutRoutine>,
    onRoutineSelected: (WorkoutRoutine) -> Unit = {},
) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState()),
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
    }
}
