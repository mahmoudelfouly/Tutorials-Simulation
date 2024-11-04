package com.melfouly.tutorialssimulation.domain.repository

import kotlinx.coroutines.flow.Flow

interface DataSource {

    fun isFirstLaunch(): Flow<Boolean>

    suspend fun setFirstLaunchComplete()
}