package de.janhopp.gymbro.ui.workout.routine

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.janhopp.gymbro.model.exercise.kg
import de.janhopp.gymbro.model.planning.PlannedExercise
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

    fun getWorkoutRoutineExercises(routineId: Int): Flow<List<PlannedExercise>> {
        return flowOf()
    }

    fun addExercises() {
    }
}
