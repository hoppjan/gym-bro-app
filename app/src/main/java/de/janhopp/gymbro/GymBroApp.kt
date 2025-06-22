package de.janhopp.gymbro

import android.app.Application
import androidx.room.Room
import de.janhopp.gymbro.db.GymDatabase
import de.janhopp.gymbro.db.daos.ExerciseExecutionDao
import de.janhopp.gymbro.db.daos.PersonDao
import de.janhopp.gymbro.db.daos.PlannedExerciseDao
import de.janhopp.gymbro.db.daos.SetDao
import de.janhopp.gymbro.db.daos.WorkoutExecutionDao
import de.janhopp.gymbro.db.daos.WorkoutPlanDao
import de.janhopp.gymbro.ui.intro.OnboardingViewModel
import de.janhopp.gymbro.ui.workout.routine.WorkoutRoutineViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

class GymBroApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@GymBroApp)
            val db = Room
                .databaseBuilder(applicationContext, GymDatabase::class.java, "gym-database")
                .build()
            modules(
                module {
                    single<GymDatabase> { db }
                    single<PersonDao> { db.personDao() }
                    single<WorkoutPlanDao> { db.workoutPlanDao() }
                    single<PlannedExerciseDao> { db.plannedExerciseDao() }
                    single<WorkoutExecutionDao> { db.workoutExecutionDao() }
                    single<ExerciseExecutionDao> { db.exerciseExecutionDao() }
                    single<SetDao> { db.setDao() }
                    viewModel { OnboardingViewModel(get()) }
                    viewModel { WorkoutRoutineViewModel() }
                },
            )
        }
    }
}
