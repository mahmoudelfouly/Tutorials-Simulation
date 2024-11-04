package com.melfouly.tutorialssimulation.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.melfouly.tutorialssimulation.presentation.navigation.BottomBar
import com.melfouly.tutorialssimulation.presentation.theme.PrimaryColor
import com.melfouly.tutorialssimulation.presentation.theme.TutorialsSimulationTheme
import com.melfouly.tutorialssimulation.presentation.ui.home.HomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TutorialsSimulationTheme {

                val selectedTab by viewModel.selectedTab.collectAsStateWithLifecycle()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomBar(selectedTab = selectedTab, onClickTab = viewModel::selectTab)
                    },
                ) { innerPadding ->
                    Crossfade(targetState = selectedTab, label = "") { destination ->
                        HomeScreen(
                            modifier = Modifier
                                .background(PrimaryColor)
                                .padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}