package com.ag.projects.sebha.presentation.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ag.projects.sebha.presentation.ui.screen.HomeScreen
import com.ag.projects.sebha.presentation.ui.theme.SebhaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SebhaTheme {
               HomeScreen()
            }
        }
    }
}

