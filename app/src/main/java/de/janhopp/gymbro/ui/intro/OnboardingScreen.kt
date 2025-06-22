package de.janhopp.gymbro.ui.intro

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import de.janhopp.gymbro.ui.navigation.Destination
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnboardingScreen(
    viewModel: OnboardingViewModel,
) {
    val navController = rememberNavController()
    val isOnboardingComplete by viewModel.isOnboardingComplete.collectAsState(initial = false)

    val name by remember { mutableStateOf("") }
    val datePickerState = rememberDatePickerState()
    val selectedDate = datePickerState.selectedDateMillis?.let {
        SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(Date(it))
    } ?: ""

    if (isOnboardingComplete)
        navController.navigate(Destination.WorkoutRoutinePicker)

    Column {
        Text(
            text = "👋",
            style = MaterialTheme.typography.headlineLarge,
        )
        Text(
            text = "Welcome!",
            style = MaterialTheme.typography.headlineMedium,
        )
        Text(
            text = "Before we start,\ntell us a bit about yourself.",
            style = MaterialTheme.typography.headlineSmall,
        )
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Name") },
        )
        DatePicker(
            state = datePickerState,
            showModeToggle = false,
        )
        if (datePickerState.selectedDateMillis != null)
            Button(
                onClick = {
                    viewModel.onboardUser(name, Date(datePickerState.selectedDateMillis!!))
                    navController.navigate(Destination.WorkoutRoutinePicker)
                }
            ) {
                Text(text = "Let's go!")
            }
    }
}
