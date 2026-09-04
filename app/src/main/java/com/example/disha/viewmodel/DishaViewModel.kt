package com.example.disha.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.disha.data.model.UserProfile

class DishaViewModel : ViewModel() {

    var userProfile by mutableStateOf(UserProfile())
        private set

    fun updateCareer(career: String) {
        userProfile = userProfile.copy(
            career = career
        )
    }

    fun updateExperience(experience: String) {
        userProfile = userProfile.copy(
            experience = experience
        )
    }

    fun updateLanguage(language: String) {
        userProfile = userProfile.copy(
            language = language
        )
    }

    fun updateInterest(interest: String) {
        userProfile = userProfile.copy(
            interest = interest
        )
    }

    fun updateLearningTime(time: String) {
        userProfile = userProfile.copy(
            learningTime = time
        )
    }
}