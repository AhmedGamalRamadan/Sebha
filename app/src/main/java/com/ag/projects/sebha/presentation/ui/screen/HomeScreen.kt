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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ag.projects.sebha.R
import com.ag.projects.sebha.presentation.ui.components.AzkarCardItem
import com.ag.projects.sebha.presentation.ui.components.alert_dialog.AlertDialogAzkar
import com.ag.projects.sebha.presentation.ui.theme.DarkBlue
import com.ag.projects.sebha.presentation.ui.theme.Green
import com.ag.projects.sebha.util.Result
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {

    val viewModel: HomeScreenViewModel = getViewModel()
    val azkar by viewModel.azkar.collectAsStateWithLifecycle()

    var showDialog by remember {
        mutableStateOf(false)
    }

    var isError by remember {
        mutableStateOf(false)
    }

    var userAzkarState by remember {
        mutableStateOf("")
    }

    val scope = rememberCoroutineScope()

    val refreshState = rememberSwipeRefreshState(false)


    Scaffold(
        modifier = modifier.fillMaxSize()
    ) { innerpadding ->

        SwipeRefresh(
            state = refreshState,
            onRefresh = {
                refreshState.isRefreshing = true
                scope.launch {
                    viewModel.getAzkar()
                    refreshState.isRefreshing = false
                }
            }
        ) {
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
                                    },
                                    onResetClick = {
                                        scope.launch {
                                            viewModel.resetAzkarToZero(item.id)
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
                    containerColor = Green,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(16.dp)

                ) {
                    Icon(
                        Icons.Filled.Add,
                        contentDescription = "Add",
                        tint = Color.White
                    )
                }
            }
            if (showDialog) {
                AlertDialogAzkar(
                    title = stringResource(R.string.add_azkar),
                    azkar = userAzkarState,
                    onValueChange = {
                        userAzkarState = it
                    },
                    onConfirmButtonClicked = {

                        if (userAzkarState.trim().isNotEmpty()) {
                            isError = false
                            scope.launch {
                                viewModel.insertAzkar(
                                    userAzkarState,
                                    count = 0
                                )
                                viewModel.getAzkar()
                                userAzkarState = ""
                                showDialog = false
                            }
                        } else {
                            isError = true
                        }
                    },
                    onDismissButtonClicked = {
                        showDialog = false
                        isError = false
                    },
                    isError = isError
                )
            }
        }
    }
}