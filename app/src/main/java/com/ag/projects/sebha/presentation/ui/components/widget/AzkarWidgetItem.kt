package com.ag.projects.sebha.presentation.ui.components.widget

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.glance.GlanceModifier
import androidx.glance.background
import androidx.glance.layout.Row
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.padding
import androidx.glance.layout.width
import androidx.glance.text.Text
import androidx.glance.text.TextAlign
import androidx.glance.text.TextStyle
import com.ag.projects.sebha.data.local.AzkarEntity

@Composable
fun AzkarWidgetItem(
    modifier: GlanceModifier = GlanceModifier,
    azkar: AzkarEntity
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.White),
    ) {
        Text(
            text = "${azkar.count}",
            style = TextStyle(
                textAlign = TextAlign.Start
            )
        )

        Spacer(modifier = modifier.width(22.dp))

        Text(
            text = azkar.azkar,
            style = TextStyle(
                textAlign = TextAlign.End
            )
        )
    }

}