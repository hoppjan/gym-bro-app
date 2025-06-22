package de.janhopp.gymbro.ui.workout.routine

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.janhopp.gymbro.model.exercise.kg
import de.janhopp.gymbro.model.planning.Exercise
import de.janhopp.gymbro.model.planning.WeightExercise
import de.janhopp.gymbro.model.planning.WorkoutPlan
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

class WorkoutRoutineViewModel(

) : ViewModel() {
    fun getWorkoutRoutines(): Flow<List<WorkoutPlan>> {
        return flowOf()
    }

    fun getWorkoutRoutine(id: Int): Flow<WorkoutPlan> {
        return flowOf(WorkoutPlan(0, "", null, null))
    }

    fun addWorkoutRoutines() {
        viewModelScope.launch {
        }
    }

    fun getWorkoutRoutineExercises(routineId: Int): Flow<List<Exercise>> {
        return flowOf()
    }

    fun addExercises() {
    }
}

private val exerciseList = listOf(
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
        id = 0,
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
    WorkoutPlan(0, "Beine", "Unterkörper", "\uD83E\uDDB5"),
    WorkoutPlan(0, "Arme", "Oberkörper", "\uD83D\uDCAA"),
    WorkoutPlan(0, "Po", "Popo", "\uD83C\uDF51"),
    WorkoutPlan(0, "Cardio", "Lässt jedes Herz höher schlagen", "❤\uFE0F"),
    WorkoutPlan(0, "Wilder Mix", "Gewichte, Gewichte, Gewichte", null),
)
