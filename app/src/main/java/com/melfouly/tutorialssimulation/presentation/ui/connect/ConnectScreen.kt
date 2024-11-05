package com.melfouly.tutorialssimulation.presentation.ui.connect

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.melfouly.tutorialssimulation.R
import com.melfouly.tutorialssimulation.domain.entity.ConnectionEntity
import com.melfouly.tutorialssimulation.presentation.theme.Gray100
import com.melfouly.tutorialssimulation.presentation.theme.GreaterMediumDimen
import com.melfouly.tutorialssimulation.presentation.theme.LargeDimen
import com.melfouly.tutorialssimulation.presentation.theme.MediumDimen
import com.melfouly.tutorialssimulation.presentation.theme.PrimaryColor
import com.melfouly.tutorialssimulation.presentation.theme.SecondaryColor
import com.melfouly.tutorialssimulation.presentation.theme.TurquoiseColor100

@Composable
fun ConnectScreen(modifier: Modifier = Modifier) {

    var selectedTab by remember { mutableIntStateOf(0) }
    val tabsList = listOf("Suggestions", "Chat")
    val connectionData = ConnectionEntity(
        name = "Mahmoud Reda",
        level = "B1",
        lastSeen = "Yesterday",
        languages = listOf("Arabic", "English", "French"),
        imageUrl = "https:.....",
        country = "Egypt",
        gender = "Male",
        birthday = "18 Nov 1996",
        age = "28"
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = GreaterMediumDimen),
    ) {

        // Top bar.
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = MediumDimen),
            text = stringResource(id = R.string.connect),
            fontSize = 24.sp,
            color = TurquoiseColor100,
            fontWeight = FontWeight.Bold
        )

        TabRow(
            modifier = Modifier.fillMaxWidth(),
            selectedTabIndex = selectedTab,
            containerColor = PrimaryColor,
            indicator = { tabPositions ->
                SecondaryIndicator(
                    Modifier.tabIndicatorOffset(tabPositions[selectedTab]),
                    color = SecondaryColor
                )
            },
            divider = { }
        ) {
            tabsList.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = {
                        Text(
                            text = title,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            overflow = TextOverflow.Ellipsis,
                            color = if (selectedTab == index) SecondaryColor else Gray100
                        )
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(LargeDimen))

        // Suggested study partners.
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = R.string.suggested_study),
                fontSize = 16.sp,
                color = TurquoiseColor100,
                fontWeight = FontWeight.Bold
            )

            Icon(
                painter = painterResource(id = R.drawable.ic_filter),
                contentDescription = "Notification icon",
                tint = Color.Unspecified
            )
        }

        Spacer(modifier = Modifier.height(GreaterMediumDimen))

        LazyColumn(
            modifier = Modifier.weight(1f),
            state = rememberLazyListState(),
            verticalArrangement = Arrangement.spacedBy(MediumDimen),
            contentPadding = PaddingValues(bottom = MediumDimen)
        ) {
            items(10) {
                ConnectionCard(modifier = Modifier.fillMaxWidth(), connection = connectionData)
            }
        }

    }
}