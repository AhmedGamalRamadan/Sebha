package com.ag.projects.sebha.presentation.ui.activities

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import com.ag.projects.sebha.presentation.ui.components.tool_bar.Toolbar
import com.ag.projects.sebha.presentation.ui.screen.HomeScreen
import com.ag.projects.sebha.presentation.ui.theme.SebhaTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val themeSharedPreferences =
            getSharedPreferences("app_theme", Context.MODE_PRIVATE)

        enableEdgeToEdge()
        setContent {

            val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

            var themeState by remember {
                mutableStateOf(
                    themeSharedPreferences.getBoolean("theme", false)
                )
            }
            SebhaTheme(
                darkTheme = themeState
            ) {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .nestedScroll(scrollBehavior.nestedScrollConnection),
                    topBar = {
                        Toolbar(
                            darkTheme = themeState,
                            scrollBehavior = scrollBehavior,
                            onThemeUpdated = {
                                themeState = !themeState
                                themeSharedPreferences
                                    .edit()
                                    .putBoolean("theme", themeState)
                                    .apply()
                            }
                        )
                    }
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        HomeScreen()
                    }
                }

            }
        }
    }
}

