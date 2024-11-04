package com.melfouly.tutorialssimulation.presentation.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.melfouly.tutorialssimulation.data.repository.DataSourceImpl
import com.melfouly.tutorialssimulation.domain.repository.DataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideDataSource(
        dataStore: DataStore<Preferences>
    ): DataSource = DataSourceImpl(dataStore)
}