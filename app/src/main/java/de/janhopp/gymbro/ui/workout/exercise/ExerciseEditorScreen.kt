package de.janhopp.gymbro.ui.workout.exercise

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import de.janhopp.gymbro.model.planning.PlannedExercise
import de.janhopp.gymbro.model.planning.WeightExercise

@Composable
fun ExerciseEditorScreen(
    exercise: PlannedExercise,
    save: (PlannedExercise) -> Unit,
) {
    val (name, setName) = remember { mutableStateOf(exercise.name) }
    val (description, setDescription) = remember { mutableStateOf(exercise.description) }
    val (equipment, setEquipment) = remember { mutableStateOf(exercise.equipment) }
    val (muscleGroup, setMuscleGroup) = remember { mutableStateOf(exercise.muscleGroup) }
    if (exercise is WeightExercise) {
        val (sets, setSets) = remember { mutableStateOf(exercise.sets) }
        val (reps, setReps) = remember { mutableStateOf(exercise.reps) }
        val (weight, setWeight) = remember { mutableStateOf(exercise.weight) }
    }
}
