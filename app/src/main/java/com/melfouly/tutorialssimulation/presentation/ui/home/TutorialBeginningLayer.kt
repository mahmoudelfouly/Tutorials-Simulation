package com.melfouly.tutorialssimulation.presentation.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.melfouly.tutorialssimulation.R
import com.melfouly.tutorialssimulation.presentation.theme.DarkBlue900
import com.melfouly.tutorialssimulation.presentation.theme.MediumDimen
import com.melfouly.tutorialssimulation.presentation.theme.PrimaryColor
import com.melfouly.tutorialssimulation.presentation.theme.TurquoiseColor50

@Composable
fun TutorialBeginningLayer(onDismiss: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBlue900)
            .zIndex(1f)
            .clickable { onDismiss() },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(MediumDimen, Alignment.CenterVertically)
    ) {
        Text(
            text = stringResource(id = R.string.welcome_tutorial),
            color = PrimaryColor,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )

        Text(
            text = stringResource(id = R.string.tap_anywhere),
            color = TurquoiseColor50,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium
        )
    }
}