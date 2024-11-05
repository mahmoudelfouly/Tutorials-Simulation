package com.melfouly.tutorialssimulation.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.melfouly.tutorialssimulation.R
import com.melfouly.tutorialssimulation.domain.entity.HighlightedData
import com.melfouly.tutorialssimulation.domain.entity.TutorialStep
import com.melfouly.tutorialssimulation.presentation.navigation.BottomBar
import com.melfouly.tutorialssimulation.presentation.navigation.NavigationTab
import com.melfouly.tutorialssimulation.presentation.theme.PrimaryColor
import com.melfouly.tutorialssimulation.presentation.theme.TutorialsSimulationTheme
import com.melfouly.tutorialssimulation.presentation.ui.connect.ConnectScreen
import com.melfouly.tutorialssimulation.presentation.ui.home.HomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            TutorialsSimulationTheme {

                val selectedTab by viewModel.selectedTab.collectAsStateWithLifecycle()
                val tabCoordinatesList = remember { mutableStateListOf<HighlightedData>() }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomBar(
                            selectedTab = selectedTab,
                            onClickTab = viewModel::selectTab,
                            onTabCoordinatesCollected = {
                                Log.d("TAG", "onCreate: $it")
                                tabCoordinatesList.addAll(it)
                            })
                    },
                ) { innerPadding ->
                    Crossfade(targetState = selectedTab, label = "") { destination ->
                        when (destination) {
                            NavigationTab.HOME -> HomeScreen(
                                modifier = Modifier
                                    .background(PrimaryColor)
                                    .padding(innerPadding),
                                tutorialStep = TutorialStep(
                                    message = stringResource(id = R.string.home_tutorial),
                                    targetScreen = "Home",
                                    highlightedData = if (tabCoordinatesList.isNotEmpty()) {
                                        tabCoordinatesList.find { it.name == NavigationTab.HOME.name }
                                    } else null
                                ),
                                navigateToNextTutorial = { viewModel.selectTab(NavigationTab.CONNECT) }
                            )

                            NavigationTab.CONNECT -> ConnectScreen(
                                modifier = Modifier
                                    .background(PrimaryColor)
                                    .padding(innerPadding),
                                tutorialStep = TutorialStep(
                                    message = stringResource(id = R.string.connect_tutorial),
                                    targetScreen = "Connect",
                                    highlightedData = if (tabCoordinatesList.isNotEmpty()) {
                                        tabCoordinatesList.find {
                                            it.name == NavigationTab.CONNECT.name
                                        }
                                    } else null
                                )
                            )

                            else -> {}
                        }
                    }
                }
            }
        }
    }
}
