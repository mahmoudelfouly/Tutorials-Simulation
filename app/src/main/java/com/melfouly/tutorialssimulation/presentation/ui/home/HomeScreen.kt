package com.melfouly.tutorialssimulation.presentation.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.melfouly.tutorialssimulation.R
import com.melfouly.tutorialssimulation.presentation.theme.DarkBlue500
import com.melfouly.tutorialssimulation.presentation.theme.GreaterMediumDimen
import com.melfouly.tutorialssimulation.presentation.theme.MediumDimen
import com.melfouly.tutorialssimulation.presentation.theme.TinyDimen
import com.melfouly.tutorialssimulation.presentation.theme.TurquoiseColor100
import com.melfouly.tutorialssimulation.presentation.theme.TurquoiseColor300
import com.melfouly.tutorialssimulation.presentation.theme.TurquoiseColor500

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = GreaterMediumDimen),
    ) {

        // Top bar.
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = MediumDimen),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = R.string.home),
                fontSize = 24.sp,
                color = TurquoiseColor100,
                fontWeight = FontWeight.Bold
            )

            Icon(
                painter = painterResource(id = R.drawable.ic_notification),
                contentDescription = "Notification icon",
                tint = Color.Unspecified
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = MediumDimen),
            horizontalArrangement = Arrangement.spacedBy(TinyDimen),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = stringResource(id = R.string.hi),
                fontWeight = FontWeight.Medium,
                color = DarkBlue500
            )

            Text(
                text = "User Name",
                fontWeight = FontWeight.Bold,
                color = TurquoiseColor500
            )
        }

        Spacer(modifier = Modifier.height(MediumDimen))

        Text(
            text = stringResource(id = R.string.study_plan),
            fontWeight = FontWeight.Bold,
            color = TurquoiseColor300
        )

        Spacer(modifier = Modifier.height(MediumDimen))

        // Phases (Since dummy data no need for list)
        Column(
            modifier = Modifier.verticalScroll(scrollState)
        ) {
            PhaseItemContent(
                image = R.drawable.first_phase,
                title = R.string.first_phase,
                isCurrentPhase = true
            )
            PhaseItemContent(image = R.drawable.second_phase, title = R.string.second_phase)
            PhaseItemContent(image = R.drawable.third_phase, title = R.string.third_phase)
            PhaseItemContent(image = R.drawable.fourth_phase, title = R.string.fourth_phase)
            PhaseItemContent(image = R.drawable.fifth_phase, title = R.string.fifth_phase)
        }
    }
}