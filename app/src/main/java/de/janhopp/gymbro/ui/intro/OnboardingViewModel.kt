package de.janhopp.gymbro.ui.intro

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.janhopp.gymbro.db.daos.PersonDao
import de.janhopp.gymbro.model.Person
import de.janhopp.gymbro.model.toPersonTable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import java.util.Date

class OnboardingViewModel(
    private val personDao: PersonDao,
): ViewModel() {
    val isOnboardingComplete: Flow<Boolean>
        get() = personDao.getAll().map { it.isNotEmpty() }

    fun onboardUser(name: String, birthday: Date) {
        viewModelScope.launch {
            personDao.insert(
                Person(id = 0, name = name, birthday = birthday).toPersonTable()
            )
        }
    }
}
