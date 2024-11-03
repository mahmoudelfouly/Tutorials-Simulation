package com.melfouly.tutorialssimulation.presentation.ui

import androidx.lifecycle.ViewModel
import com.melfouly.tutorialssimulation.presentation.navigation.NavigationTab
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    private val _selectedTab = MutableStateFlow(NavigationTab.HOME)
    val selectedTab: StateFlow<NavigationTab> = _selectedTab

    fun selectTab(tab: NavigationTab) {
        if (_selectedTab.value != tab) {
            _selectedTab.update { tab }
        }
    }

}