package de.janhopp.gymbro.model.planning

import de.janhopp.gymbro.db.model.planning.WorkoutPlanTable

data class WorkoutPlan(
    val id: Int,
    val name: String,
    val description: String?,
    val icon: String?,
    val exercises: List<PlannedExercise> = emptyList(),
)

// TODO: add planned exercises
fun WorkoutPlanTable.toWorkoutPlan() =
    WorkoutPlan(id, name, description, icon, emptyList())

fun WorkoutPlan.toWorkoutPlanTable(personId: Int) =
    WorkoutPlanTable(id, name, description, icon, personId)
