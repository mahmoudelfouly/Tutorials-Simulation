package com.melfouly.tutorialssimulation.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.melfouly.tutorialssimulation.presentation.navigation.BottomBar
import com.melfouly.tutorialssimulation.presentation.theme.TutorialsSimulationTheme
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

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomBar(selectedTab = selectedTab, onClickTab = viewModel::selectTab)
                    },
                ) { innerPadding ->
                    Crossfade(targetState = selectedTab, label = "") { destination ->
                        Box(modifier = Modifier.fillMaxSize()) {
                            Text(text = "Hello")
                        }
                    }
                }
            }
        }
    }
}