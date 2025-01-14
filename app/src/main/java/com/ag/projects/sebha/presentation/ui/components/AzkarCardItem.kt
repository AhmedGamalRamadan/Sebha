package com.ag.projects.sebha.presentation.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Replay
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ag.projects.sebha.R
import com.ag.projects.sebha.data.local.AzkarEntity

@Composable
fun AzkarCardItem(
    modifier: Modifier = Modifier,
    azkar: AzkarEntity,
    onItemClick: () -> Unit,
    onDeleteClick: () -> Unit,
    onResetClick: () -> Unit,
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 100.dp)
            .padding(8.dp)
            .clickable {
                onItemClick()
            },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp,
            pressedElevation = 8.dp
        ),
        border = BorderStroke(
            width = 3.dp,
            color = Color.Green
        )
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = azkar.count.toString(),
                    modifier = modifier
                        .wrapContentSize()
                        .padding(end = 4.dp, bottom = 4.dp),
                    color = Color.Black,
                    fontSize = 22.sp,
                    textAlign = TextAlign.Start
                )

                Text(
                    text = azkar.azkar,
                    modifier = modifier
                        .fillMaxWidth(),
                    color = Color.Black,
                    fontSize = 22.sp,
                    textAlign = TextAlign.End
                )
            }

            Row(
                modifier = modifier
                    .fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = stringResource(R.string.delete),
                    tint = Color.Red,
                    modifier = modifier
                        .clickable {
                            onDeleteClick()
                        }
                )

                Spacer(modifier = modifier.width(10.dp))

                Icon(
                    imageVector = Icons.Filled.Replay,
                    contentDescription = stringResource(R.string.delete),
                    tint = Color.Green,
                    modifier = modifier
                        .clickable {
                            onResetClick()
                        }
                )
            }
        }
    }
}

@Preview
@Composable
private fun AzkarCardItemPreview() {
    AzkarCardItem(
        modifier = Modifier,
        azkar = AzkarEntity(
            count = 10,
            azkar = "الحمد لله رب العالمين "
        ),
        onItemClick = {},
        onDeleteClick = {},
        onResetClick = {}
    )
}