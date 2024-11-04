package com.melfouly.tutorialssimulation.presentation.ui.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.melfouly.tutorialssimulation.presentation.theme.Gray50
import com.melfouly.tutorialssimulation.presentation.theme.LargeDimen
import com.melfouly.tutorialssimulation.presentation.theme.TurquoiseColor50
import com.melfouly.tutorialssimulation.presentation.theme.UpperMediumDimen

@Composable
fun PhaseItemContent(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
    @StringRes title: Int,
    isCurrentPhase: Boolean = false
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(LargeDimen)
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "Phase image"
        )

        Text(
            modifier = Modifier.padding(bottom = UpperMediumDimen),
            text = stringResource(id = title),
            color = if (isCurrentPhase) TurquoiseColor50 else Gray50
        )
    }
}