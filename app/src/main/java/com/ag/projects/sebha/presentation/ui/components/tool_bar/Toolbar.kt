package com.ag.projects.sebha.presentation.ui.components.tool_bar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ag.projects.sebha.presentation.ui.components.theme_switcher.ThemeSwitcher

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar(
    darkTheme: Boolean,
    scrollBehavior: TopAppBarScrollBehavior,
    onThemeUpdated: () -> Unit
) {

    TopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Text(
                text = "Sebha",
                fontSize = 26.sp,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        actions = {
            ThemeSwitcher(
                darkTheme = darkTheme,
                padding = 8.dp,
                onClick = {
                    onThemeUpdated()
                }
            )
        }
    )
}