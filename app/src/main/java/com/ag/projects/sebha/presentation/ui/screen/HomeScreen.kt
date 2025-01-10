package com.ag.projects.sebha.presentation.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ag.projects.sebha.presentation.ui.components.AzkarCardItem
import com.ag.projects.sebha.presentation.ui.components.alert_dialog.AlertDialogAzkar
import com.ag.projects.sebha.util.Result
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel
import org.koin.ext.clearQuotes

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {

    val viewModel: HomeScreenViewModel = getViewModel()
    val azkar by viewModel.azkar.collectAsState()

    var showDialog by remember {
        mutableStateOf(false)
    }

    var userAzkarState by remember {
        mutableStateOf("")
    }

    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = modifier.fillMaxSize()
    ) { innerpadding ->

        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(innerpadding)
        ) {

            LazyColumn(
                modifier = modifier.fillMaxSize()
            ) {

                when (azkar) {
                    is Result.Success -> {
                        val azkarList = (azkar as Result.Success).data

                        items(azkarList) { item ->
                            AzkarCardItem(
                                modifier = modifier,
                                azkar = item,
                                onItemClick = {
                                    //increment the count
                                    scope.launch {
                                        viewModel.incrementAzkarCount(item.id)
                                        viewModel.getAzkar()
                                    }
                                },
                                onDeleteClick = {
                                   scope.launch {
                                       viewModel.deleteAzkar(item.id)
                                       viewModel.getAzkar()
                                   }
                                }
                            )
                        }
                    }

                    is Result.Error -> {
                        Log.d("Home Screen ", "Error ")
                    }

                    Result.Loading -> {
                        Log.d("Home Screen ", "Loading ")
                    }
                }
            }

            FloatingActionButton(
                onClick = {
                    showDialog = true
                },
                containerColor = Color.Green,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)

            ) {
                Icon(Icons.Filled.Add, contentDescription = "Add")
            }
        }
        if (showDialog) {
            AlertDialogAzkar(
                title = "Add Azkar",
                azkar = userAzkarState,
                onValueChange = {
                    userAzkarState = it
                },
                onConfirmButtonClicked = {
                    scope.launch {
                        viewModel.insertAzkar(
                            userAzkarState,
                            count = 0
                        )
                        viewModel.getAzkar()
                    }
                    showDialog = false
                },
                onDismissButtonClicked = {
                    showDialog = false
                },
            )
        }
    }
}