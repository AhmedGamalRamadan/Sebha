package com.ag.projects.sebha.presentation.ui.components.tool_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ag.projects.sebha.presentation.ui.components.theme_switcher.ThemeSwitcher
import com.ag.projects.sebha.presentation.ui.theme.DarkBlue

@Composable
fun Toolbar(
    modifier: Modifier = Modifier,
    darkTheme: Boolean,
    onThemeUpdated: () -> Unit
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(top = 8.dp)
            .background(DarkBlue),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Sebha",
            fontSize = 26.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = modifier
                .padding(8.dp)
        )

        ThemeSwitcher(
            darkTheme = darkTheme,
            padding = 8.dp,
            onClick = {
                onThemeUpdated()
            }
        )
    }

}