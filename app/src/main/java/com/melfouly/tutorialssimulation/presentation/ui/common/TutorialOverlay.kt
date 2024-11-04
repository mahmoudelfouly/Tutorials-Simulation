package com.melfouly.tutorialssimulation.presentation.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.melfouly.tutorialssimulation.presentation.theme.DarkBlue500
import com.melfouly.tutorialssimulation.presentation.theme.MediumDimen
import com.melfouly.tutorialssimulation.presentation.theme.PrimaryColor
import com.melfouly.tutorialssimulation.presentation.theme.SmallDimen
import kotlin.math.roundToInt

@Composable
fun TutorialOverlay(
    message: String,
    xOffset: Float,
    yOffset: Float,
    size: IntSize,
    onNext: () -> Unit
) {

    val density = LocalDensity.current
    val widthDp = with(density) { size.width.toDp() }
    val heightDp = with(density) { size.height.toDp() }
    var messageHeightDp by remember { mutableStateOf(0.dp) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.4f))
            .zIndex(1f)
            .clickable { onNext() }
    ) {

        // Highlighted section.
        Box(
            modifier = Modifier
                .offset { IntOffset(xOffset.roundToInt(), yOffset.roundToInt()) }
                .size(widthDp, heightDp)
                .clip(RoundedCornerShape(MediumDimen))
                .background(PrimaryColor)
        )

        // Message.
        Box(
            modifier = Modifier
                .onGloballyPositioned { coordinates ->
                    messageHeightDp = coordinates.size.height.dp
                }
                .offset {
                    IntOffset(
                        (xOffset + SmallDimen.toPx()).roundToInt(),
                        (yOffset - messageHeightDp.toPx() / 3 - MediumDimen.toPx()).roundToInt()
                    )
                }
                .clip(RoundedCornerShape(MediumDimen))
                .background(DarkBlue500)
                .padding(vertical = SmallDimen, horizontal = MediumDimen)
        ) {
            Text(
                text = message,
                color = PrimaryColor,
                fontSize = 16.sp
            )
        }
    }
}
