package com.ag.projects.sebha.presentation.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.ag.projects.sebha.presentation.ui.components.tool_bar.Toolbar
import com.ag.projects.sebha.presentation.ui.screen.HomeScreen
import com.ag.projects.sebha.presentation.ui.theme.SebhaTheme

class MainActivity : ComponentActivity() {

//    private val themeSharedPreferences = getSharedPreferences("theme", Context.MODE_PRIVATE)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var themeState by remember {
                mutableStateOf(true)
            }
            SebhaTheme(
                darkTheme = themeState
//                darkTheme = themeSharedPreferences.getBoolean("theme", false)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Toolbar(
                        darkTheme = themeState,
                        onThemeUpdated = {
                            themeState = !themeState
//                        themeSharedPreferences
//                            .edit()
//                            .putBoolean("theme",true)
//                            .apply()
                        }
                    )
                    HomeScreen()
                }

            }
        }
    }
}

