package com.example.disha.ui.screens.assessment

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun SkillAssessmentScreen(
    onAssessmentCompleted: () -> Unit
) {

    val blueBackground = Color(0xFF1E3A8A)

    var currentStep by remember {
        mutableIntStateOf(1)
    }

    var selectedExperience by remember {
        mutableStateOf<String?>(null)
    }

    var selectedLanguage by remember {
        mutableStateOf<String?>(null)
    }

    var selectedSkill by remember {
        mutableStateOf<String?>(null)
    }

    var selectedTime by remember {
        mutableStateOf<String?>(null)
    }

    val experienceLevels = listOf(
        "Beginner",
        "Some Experience",
        "Intermediate",
        "Advanced"
    )

    val languages = listOf(
        "Java / Kotlin",
        "Python",
        "JavaScript",
        "C / C++",
        "I haven't started yet"
    )

    val skills = listOf(
        "Mobile Development",
        "Web Development",
        "Data & AI",
        "Problem Solving",
        "None yet"
    )

    val learningTime = listOf(
        "1–3 hours",
        "4–7 hours",
        "8–15 hours",
        "15+ hours"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(blueBackground)
            .padding(28.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "SKILL ASSESSMENT",
            style = MaterialTheme.typography.labelLarge,
            color = Color.White.copy(alpha = 0.7f),
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Step $currentStep of 4",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White.copy(alpha = 0.7f)
        )

        Spacer(modifier = Modifier.height(40.dp))

        when (currentStep) {

            1 -> AssessmentQuestion(
                title = "Where are you\nstarting from?",
                description = "How would you describe your current experience?",
                options = experienceLevels,
                selectedOption = selectedExperience,
                onOptionSelected = {
                    selectedExperience = it
                },
                blueBackground = blueBackground
            )

            2 -> AssessmentQuestion(
                title = "What languages\ndo you know?",
                description = "Choose the language you are most comfortable with.",
                options = languages,
                selectedOption = selectedLanguage,
                onOptionSelected = {
                    selectedLanguage = it
                },
                blueBackground = blueBackground
            )

            3 -> AssessmentQuestion(
                title = "What interests\nyou most?",
                description = "Choose the area you have explored or enjoy.",
                options = skills,
                selectedOption = selectedSkill,
                onOptionSelected = {
                    selectedSkill = it
                },
                blueBackground = blueBackground
            )

            4 -> AssessmentQuestion(
                title = "How much time\ncan you invest?",
                description = "Choose the time you can consistently spend learning each week.",
                options = learningTime,
                selectedOption = selectedTime,
                onOptionSelected = {
                    selectedTime = it
                },
                blueBackground = blueBackground
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        val canContinue = when (currentStep) {
            1 -> selectedExperience != null
            2 -> selectedLanguage != null
            3 -> selectedSkill != null
            else -> selectedTime != null
        }

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {

            if (currentStep > 1) {

                Button(
                    onClick = {
                        currentStep--
                    },
                    modifier = Modifier
                        .weight(1f)
                        .height(54.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White.copy(alpha = 0.15f),
                        contentColor = Color.White
                    )
                ) {
                    Text("Back")
                }

                Spacer(modifier = Modifier.weight(0.1f))
            }

            Button(
                onClick = {

                    if (currentStep < 4) {
                        currentStep++
                    } else {
                        onAssessmentCompleted()
                    }
                },
                enabled = canContinue,
                modifier = Modifier
                    .weight(1f)
                    .height(54.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = blueBackground,
                    disabledContainerColor = Color.White.copy(alpha = 0.4f),
                    disabledContentColor = blueBackground.copy(alpha = 0.6f)
                )
            ) {

                Text(
                    text = if (currentStep == 4) {
                        "Generate My Direction"
                    } else {
                        "Continue"
                    },
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}


@Composable
private fun AssessmentQuestion(
    title: String,
    description: String,
    options: List<String>,
    selectedOption: String?,
    onOptionSelected: (String) -> Unit,
    blueBackground: Color
) {

    Text(
        text = title,
        style = MaterialTheme.typography.headlineLarge,
        color = Color.White,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )

    Spacer(modifier = Modifier.height(16.dp))

    Text(
        text = description,
        style = MaterialTheme.typography.bodyLarge,
        color = Color.White.copy(alpha = 0.78f),
        textAlign = TextAlign.Center
    )

    Spacer(modifier = Modifier.height(32.dp))

    options.forEach { option ->

        val isSelected = selectedOption == option

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp)
                .clickable {
                    onOptionSelected(option)
                },
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = if (isSelected) {
                    Color.White
                } else {
                    Color.White.copy(alpha = 0.12f)
                }
            )
        ) {

            Text(
                text = option,
                modifier = Modifier.padding(20.dp),
                style = MaterialTheme.typography.titleMedium,
                color = if (isSelected) {
                    blueBackground
                } else {
                    Color.White
                },
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}