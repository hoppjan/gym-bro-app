package de.janhopp.gymbro.db.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import de.janhopp.gymbro.db.model.PersonTable

@Dao
interface PersonDao {
    @Insert
    fun insert(person: PersonTable)

    @Query("SELECT * FROM persontable")
    fun getAll(): List<PersonTable>

    @Query("SELECT * FROM persontable WHERE id = :id")
    fun getById(id: Int): PersonTable

    @Query("SELECT * FROM persontable WHERE name = :name")
    fun getByName(name: String): PersonTable

    @Query("SELECT * FROM persontable LIMIT 1")
    fun getFirst(): PersonTable

    @Update
    fun update(person: PersonTable)

    @Delete
    fun delete(person: PersonTable)
}
