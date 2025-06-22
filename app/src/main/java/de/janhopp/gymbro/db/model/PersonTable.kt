package de.janhopp.gymbro.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PersonTable(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
)
