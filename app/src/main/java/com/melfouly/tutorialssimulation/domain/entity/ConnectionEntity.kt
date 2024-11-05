package com.melfouly.tutorialssimulation.domain.entity

import androidx.compose.runtime.Stable

@Stable
data class ConnectionEntity(
    val name: String,
    val level: String,
    val lastSeen: String,
    val languages: List<String>,
    val imageUrl: String,
    val country: String,
    val gender: String,
    val birthday: String,
    val age: String
)
