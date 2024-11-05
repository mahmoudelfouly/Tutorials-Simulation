package com.melfouly.tutorialssimulation.presentation.ui.common

import android.util.Log
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
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

    val context = LocalContext.current
    val displayMetrics = context.resources.displayMetrics

    val screenWidth = displayMetrics.widthPixels.dp
    val screenHeight = displayMetrics.heightPixels.dp
    val density = LocalDensity.current
    val widthDp = with(density) { size.width.toDp() }
    val heightDp = with(density) { size.height.toDp() }
    var messageWidthDp by remember { mutableStateOf(0.dp) }
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
                    messageWidthDp = coordinates.size.width.dp
                }
                .offset {
                    val adjustedXDp =
                        if (xOffset.roundToInt().dp + messageWidthDp + SmallDimen > screenWidth) {
                            // Ensure the Box does not go off the right edge of the screen
                            val overLimitWidthDp =
                                (xOffset.roundToInt().dp + messageWidthDp + SmallDimen) - screenWidth
                            Log.d(
                                "TAG",
                                "TutorialOverlay: inside if: messageWidth=$messageWidthDp, screenWidth=$screenWidth, total=${xOffset.roundToInt().dp + messageWidthDp + SmallDimen}, overLimit=${(xOffset.roundToInt().dp + messageWidthDp + SmallDimen) - screenWidth}, rightPlace=${(screenWidth.toPx() - xOffset - overLimitWidthDp.toPx()).dp}"
                            )
                            0.dp
//                        (screenWidth.toPx() - xOffset - overLimitWidthDp.toPx()).dp
//                        screenWidth - messageWidthDp - MediumDimen
                        } else {
                            Log.d(
                                "TAG",
                                "TutorialOverlay: inside else: ${(xOffset + SmallDimen.toPx()).dp}"
                            )
                            (xOffset + SmallDimen.toPx()).dp
                        }
                    IntOffset(
                        adjustedXDp
                            .toPx()
                            .roundToInt(),
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
