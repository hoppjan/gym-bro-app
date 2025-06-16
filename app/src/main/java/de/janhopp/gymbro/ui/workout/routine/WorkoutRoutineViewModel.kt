package de.janhopp.gymbro.ui.workout.routine

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.janhopp.gymbro.db.ExerciseDao
import de.janhopp.gymbro.db.WorkoutRoutineDao
import de.janhopp.gymbro.model.exercise.Exercise
import de.janhopp.gymbro.model.exercise.WeightExercise
import de.janhopp.gymbro.model.exercise.kg
import de.janhopp.gymbro.model.exercise.toExercise
import de.janhopp.gymbro.model.workout.WorkoutRoutine
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class WorkoutRoutineViewModel(
    private val workoutRoutines: WorkoutRoutineDao,
    private val exercises: ExerciseDao,
) : ViewModel() {
    fun getWorkoutRoutines(): Flow<List<WorkoutRoutine>> {
        return workoutRoutines.getAll()
    }

    fun getWorkoutRoutine(id: Int): Flow<WorkoutRoutine> {
        return workoutRoutines.findById(id)
    }

    fun addWorkoutRoutines() {
        viewModelScope.launch {
            workoutRoutines.insertAll(*routines.toTypedArray())
        }
    }

    fun getWorkoutRoutineExercises(routineId: Int): Flow<List<Exercise>> {
        return exercises.getAll().map { list -> list.map { it.toExercise() } }
    }
}

private val exercises = listOf(
    WeightExercise(
        id = 0,
        name = "Leg Press",
        description = "Wie Kniebeugen im Autsch-Modus",
        equipment = "Leg press",
        muscleGroup = "Beine",
        sets = 3,
        reps = 12,
        weight = 80.kg,
    ),
    WeightExercise(
        id = 1,
        name = "Leg Press 2",
        description = "Wie Kniebeugen im Autsch-Modus 2",
        equipment = "Wieder Leg press",
        muscleGroup = "Beine",
        sets = 3,
        reps = 12,
        weight = 120.kg,
    ),
)

private val routines = listOf(
    WorkoutRoutine(0, "Beine", "Unterkörper", "\uD83E\uDDB5"),
    WorkoutRoutine(0, "Arme", "Oberkörper", "\uD83D\uDCAA"),
    WorkoutRoutine(0, "Po", "Popo", "\uD83C\uDF51"),
    WorkoutRoutine(0, "Cardio", "Lässt jedes Herz höher schlagen", "❤\uFE0F"),
    WorkoutRoutine(0, "Wilder Mix", "Gewichte, Gewichte, Gewichte", null),
)
