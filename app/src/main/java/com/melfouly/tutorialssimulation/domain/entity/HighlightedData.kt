package com.melfouly.tutorialssimulation.domain.entity

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.IntSize

data class HighlightedData(
    val name: String,
    val position: Offset,
    val size: IntSize
)
