package com.melfouly.tutorialssimulation.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.melfouly.tutorialssimulation.presentation.theme.MediumDimen
import com.melfouly.tutorialssimulation.presentation.theme.SecondaryColor
import com.melfouly.tutorialssimulation.presentation.theme.ThirdColor

@Composable
fun BottomBar(selectedTab: NavigationTab, onClickTab: (NavigationTab) -> Unit) {

    val tabs = NavigationTab.entries

    NavigationBar(
        containerColor = Color.White,
    ) {
        tabs.forEach { tab ->
            NavigationBarItem(
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
    }
}