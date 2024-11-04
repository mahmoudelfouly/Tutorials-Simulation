package com.melfouly.tutorialssimulation.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import com.melfouly.tutorialssimulation.domain.helper.ConstantHelper.IS_FIRST_LAUNCH_KEY
import com.melfouly.tutorialssimulation.domain.repository.DataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataSourceImpl(private val dataStore: DataStore<Preferences>) : DataSource {

    private val firstLaunchKey = booleanPreferencesKey(IS_FIRST_LAUNCH_KEY)

    override fun isFirstLaunch(): Flow<Boolean> {
        return dataStore.data.map { preferences ->
            preferences[firstLaunchKey] ?: true
        }
    }

    override suspend fun setFirstLaunchComplete() {
        dataStore.edit { preferences ->
            preferences[firstLaunchKey] = false
        }
    }
}