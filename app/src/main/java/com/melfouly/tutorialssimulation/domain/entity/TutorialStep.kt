package com.melfouly.tutorialssimulation.domain.entity

data class TutorialStep(
    val message: String,
    val targetScreen: String,
    val highlightedData: HighlightedData?
)
