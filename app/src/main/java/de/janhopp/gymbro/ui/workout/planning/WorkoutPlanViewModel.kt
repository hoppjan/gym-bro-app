package de.janhopp.gymbro.ui.workout.planning

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.janhopp.gymbro.db.daos.PlannedExerciseDao
import de.janhopp.gymbro.db.daos.WorkoutPlanDao
import de.janhopp.gymbro.model.planning.PlannedExercise
import de.janhopp.gymbro.model.planning.WorkoutPlan
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

class WorkoutPlanViewModel(
    private val workoutPlanDao: WorkoutPlanDao,
    private val plannedExerciseDao: PlannedExerciseDao,
) : ViewModel() {
    fun getWorkoutPlans(): Flow<List<WorkoutPlan>> {
        return flowOf()
    }

    fun getWorkoutPlan(id: Int): Flow<WorkoutPlan> {
        return flowOf(WorkoutPlan(0, "", null, null))
    }

    fun addWorkoutPlans() {
        viewModelScope.launch {

        }
    }

    fun getWorkoutPlanExercises(workoutPlanId: Int): Flow<List<PlannedExercise>> {
        return flowOf()
    }

    fun addExercises() {
    }
}
