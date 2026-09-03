package com.example.disha.ui.screens.career

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CareerSelectionScreen(
    onCareerSelected: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Choose Your Career Goal",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Select the career path you want to work toward.",
            modifier = Modifier.padding(top = 12.dp)
        )

        Button(
            onClick = onCareerSelected,
            modifier = Modifier.padding(top = 32.dp)
        ) {
            Text("Android Developer")
        }
    }
}