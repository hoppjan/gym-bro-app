package de.janhopp.gymbro.ui.workout.planning

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.janhopp.gymbro.db.daos.PlannedExerciseDao
import de.janhopp.gymbro.db.daos.WorkoutPlanDao
import de.janhopp.gymbro.model.exercise.kg
import de.janhopp.gymbro.model.planning.BodyWeightExercise
import de.janhopp.gymbro.model.planning.PlannedExercise
import de.janhopp.gymbro.model.planning.WeightExercise
import de.janhopp.gymbro.model.planning.WorkoutPlan
import de.janhopp.gymbro.model.planning.toPlannedExercise
import de.janhopp.gymbro.model.planning.toWorkoutPlan
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class WorkoutPlanViewModel(
    private val workoutPlanDao: WorkoutPlanDao,
    private val plannedExerciseDao: PlannedExerciseDao,
) : ViewModel() {
    fun getWorkoutPlans(): Flow<List<WorkoutPlan>> {
        return workoutPlanDao.getAll()
            .map { list -> list.map { it.toWorkoutPlan() } + workoutPlans }
    }

    fun getWorkoutPlan(id: Int): Flow<WorkoutPlan> {
        return flowOf(WorkoutPlan(id, "Arme", "Oberkörper", "\uD83D\uDCAA"))
        // workoutPlanDao.getById(id).map { it.toWorkoutPlan() }
    }

    fun addWorkoutPlans() {
        viewModelScope.launch {

        }
    }

    fun getWorkoutPlanExercises(workoutPlanId: Int): Flow<List<PlannedExercise>> {
        return plannedExerciseDao.getByWorkoutPlanId(workoutPlanId)
            .map { list -> list.map { it.toPlannedExercise() } + exercises }
    }

    fun addExercises() {
    }
}

private val exercises = listOf(
    BodyWeightExercise(
        id = 2,
        name = "Klimmzüge",
        index = 2,
        pauseInBetween = 30,
        pauseAfterwards = 60,
        description = null,
        equipment = "Klimmzugstange",
        muscleGroup = "Arme/Schultern",
        sets = 3,
        reps = 8,
    ),
    WeightExercise(
        id = 3,
        name = "Bankdrücken",
        index = 3,
        pauseInBetween = 30,
        pauseAfterwards = 60,
        description = null,
        equipment = "Langhantel & -Bank",
        muscleGroup = "Arme/Brust",
        sets = 3,
        reps = 12,
        weight = 45.kg,
    ),
    BodyWeightExercise(
        id = 4,
        name = "Dips",
        index = 4,
        pauseInBetween = 30,
        pauseAfterwards = 60,
        description = null,
        equipment = null,
        muscleGroup = "Arme/Brust/Rücken",
        sets = 3,
        reps = 12,
    ),
    BodyWeightExercise(
        id = 5,
        name = "Liegestütz",
        index = 5,
        pauseInBetween = 30,
        pauseAfterwards = 60,
        description = null,
        equipment = null,
        muscleGroup = "Arme/Brust/Rücken",
        sets = 3,
        reps = 12,
    ),
    WeightExercise(
        id = 6,
        name = "Arnold Press",
        index = 6,
        pauseInBetween = 30,
        pauseAfterwards = 60,
        description = null,
        equipment = "Kurzhanteln",
        muscleGroup = "Arme/Schultern",
        sets = 3,
        reps = 12,
        weight = 12.kg,
    )
)

private val workoutPlans = listOf(
    WorkoutPlan(0, "Beine", "Unterkörper", "\uD83E\uDDB5"),
    WorkoutPlan(1, "Arme", "Oberkörper", "\uD83D\uDCAA"),
    WorkoutPlan(2, "Po", "Popo", "\uD83C\uDF51"),
    WorkoutPlan(3, "Cardio", "Lässt jedes Herz höher schlagen", "❤\uFE0F"),
)
