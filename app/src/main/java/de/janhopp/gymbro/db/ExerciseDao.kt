package de.janhopp.gymbro.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import de.janhopp.gymbro.model.exercise.ExerciseTable
import kotlinx.coroutines.flow.Flow

@Dao
interface ExerciseDao {
    @Query("SELECT * FROM ExerciseTable")
    fun getAll(): Flow<List<ExerciseTable>>

    @Query("SELECT * FROM ExerciseTable WHERE id = :id")
    fun findById(id: Int): Flow<ExerciseTable>

    @Query("SELECT * FROM ExerciseTable WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String): Flow<ExerciseTable>

    @Insert
    suspend fun insertAll(vararg users: ExerciseTable)

    @Delete
    suspend fun delete(user: ExerciseTable)
}
