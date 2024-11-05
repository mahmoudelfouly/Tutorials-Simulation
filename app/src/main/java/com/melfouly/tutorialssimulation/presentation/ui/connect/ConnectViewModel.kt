package com.melfouly.tutorialssimulation.presentation.ui.connect

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melfouly.tutorialssimulation.domain.repository.DataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConnectViewModel @Inject constructor(private val dataSource: DataSource) : ViewModel() {

    private val _isFirstLaunchState = MutableStateFlow(false)
    val isFirstLaunchState: StateFlow<Boolean> = _isFirstLaunchState

    fun isFirstLaunch() {
        viewModelScope.launch(Dispatchers.IO) {
            dataSource.isFirstLaunch().collect {
                _isFirstLaunchState.value = it
            }
        }
    }

    fun setFirstLaunchComplete() {
        viewModelScope.launch(Dispatchers.IO) {
            dataSource.setFirstLaunchComplete()
        }
    }
}