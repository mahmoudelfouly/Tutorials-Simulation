package com.melfouly.tutorialssimulation.presentation.ui.connect

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.melfouly.tutorialssimulation.R
import com.melfouly.tutorialssimulation.domain.entity.ConnectionEntity
import com.melfouly.tutorialssimulation.presentation.theme.Gray100
import com.melfouly.tutorialssimulation.presentation.theme.Gray50
import com.melfouly.tutorialssimulation.presentation.theme.GreaterMediumDimen
import com.melfouly.tutorialssimulation.presentation.theme.HugeDimen
import com.melfouly.tutorialssimulation.presentation.theme.MediumDimen
import com.melfouly.tutorialssimulation.presentation.theme.PrimaryColor
import com.melfouly.tutorialssimulation.presentation.theme.SecondaryColor
import com.melfouly.tutorialssimulation.presentation.theme.SmallDimen
import com.melfouly.tutorialssimulation.presentation.theme.ThirdColor
import com.melfouly.tutorialssimulation.presentation.theme.TinyDimen
import com.melfouly.tutorialssimulation.presentation.theme.TurquoiseColor300
import com.melfouly.tutorialssimulation.presentation.theme.TurquoiseColor500
import com.melfouly.tutorialssimulation.presentation.theme.TurquoiseFadingColor
import com.melfouly.tutorialssimulation.presentation.theme.UpperMediumDimen

@Composable
fun ConnectionCard(
    modifier: Modifier = Modifier,
    connection: ConnectionEntity
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(GreaterMediumDimen),
        colors = CardDefaults.cardColors(containerColor = PrimaryColor),
        border = BorderStroke(1.dp, Gray50),
        elevation = CardDefaults.cardElevation(defaultElevation = MediumDimen)
    ) {
        Row(
            modifier = Modifier.padding(vertical = UpperMediumDimen, horizontal = UpperMediumDimen),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Avatar image
            Image(
                modifier = Modifier.size(HugeDimen),
                painter = painterResource(id = R.drawable.avatar),
                contentDescription = "Avatar image"
            )

            Spacer(modifier = Modifier.width(MediumDimen))

            // Name, Level, Last seen & Languages.
            Column {
                Row {
                    // Name
                    Text(
                        text = connection.name,
                        color = TurquoiseColor300,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.width(SmallDimen))

                    // Targeting level
                    Text(
                        modifier = Modifier
                            .clip(RoundedCornerShape(TinyDimen))
                            .background(SecondaryColor)
                            .padding(vertical = TinyDimen, horizontal = SmallDimen),
                        text = stringResource(id = R.string.targeting, connection.level),
                        color = PrimaryColor,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                // Last seen
                Text(
                    text = stringResource(id = R.string.last_seen, connection.lastSeen),
                    color = Gray100,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )

                // Languages
                Row(horizontalArrangement = Arrangement.spacedBy(SmallDimen)) {
                    connection.languages.forEach {
                        Text(
                            modifier = Modifier
                                .clip(RoundedCornerShape(TinyDimen))
                                .background(TurquoiseFadingColor)
                                .padding(vertical = TinyDimen, horizontal = SmallDimen),
                            text = it,
                            color = TurquoiseColor500,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }

        Row(
            modifier = Modifier
                .padding(horizontal = UpperMediumDimen)
                .padding(bottom = UpperMediumDimen),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(MediumDimen)
        ) {
            // Country
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(SmallDimen)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_location),
                    contentDescription = "Location icon",
                    tint = Color.Unspecified
                )
                Text(
                    text = connection.country,
                    color = ThirdColor,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            // Gender
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(SmallDimen)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_gender),
                    contentDescription = "Gender icon",
                    tint = Color.Unspecified
                )
                Text(
                    text = connection.gender,
                    color = ThirdColor,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            // Age
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(SmallDimen)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_birthday),
                    contentDescription = "Age icon",
                    tint = Color.Unspecified
                )
                Text(
                    text = connection.age,
                    color = ThirdColor,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            // Birthday
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(SmallDimen)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_calendar),
                    contentDescription = "Location icon",
                    tint = Color.Unspecified
                )
                Text(
                    text = connection.birthday,
                    color = ThirdColor,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}