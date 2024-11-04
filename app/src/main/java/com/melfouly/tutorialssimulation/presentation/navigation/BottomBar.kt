package com.melfouly.tutorialssimulation.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.melfouly.tutorialssimulation.domain.entity.HighlightedData
import com.melfouly.tutorialssimulation.presentation.theme.BottomBarColor
import com.melfouly.tutorialssimulation.presentation.theme.MediumDimen
import com.melfouly.tutorialssimulation.presentation.theme.SecondaryColor
import com.melfouly.tutorialssimulation.presentation.theme.ThirdColor

@Composable
fun BottomBar(
    selectedTab: NavigationTab,
    onClickTab: (NavigationTab) -> Unit,
    onTabCoordinatesCollected: (List<HighlightedData>) -> Unit
) {

    val tabs = NavigationTab.entries

    NavigationBar(
        containerColor = BottomBarColor,
        tonalElevation = MediumDimen
    ) {

        val tabCoordinatesList = remember { mutableStateListOf<HighlightedData>() }

        tabs.forEach { tab ->
            NavigationBarItem(
                modifier = Modifier.onGloballyPositioned { coordinates ->
                    val position = coordinates.positionInWindow()
                    val size = coordinates.size

                    // Check if this tab data already exists, to avoid adding it multiple times
                    val existingIndex = tabCoordinatesList.indexOfFirst { it.name == tab.name }
                    if (existingIndex >= 0) {
                        // Update existing entry
                        tabCoordinatesList[existingIndex] =
                            HighlightedData(tab.name, position, size)
                    } else {
                        // Add new entry
                        tabCoordinatesList.add(HighlightedData(tab.name, position, size))
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = tab.icon),
                        contentDescription = stringResource(id = tab.title),
                        modifier = Modifier.padding(MediumDimen)
                    )
                },
                label = {
                    Text(text = stringResource(id = tab.title))
                },
                selected = tab == selectedTab,
                onClick = { onClickTab(tab) },
                colors = NavigationBarItemDefaults
                    .colors(
                        selectedIconColor = SecondaryColor,
                        selectedTextColor = SecondaryColor,
                        unselectedIconColor = ThirdColor,
                        unselectedTextColor = ThirdColor,
                        indicatorColor = Color.Transparent
                    )
            )
        }

        onTabCoordinatesCollected(tabCoordinatesList.toList())
    }
}