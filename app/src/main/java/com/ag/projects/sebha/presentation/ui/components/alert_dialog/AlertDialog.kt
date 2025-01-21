package com.ag.projects.sebha.presentation.ui.components.alert_dialog

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ag.projects.sebha.R

@Composable
fun AlertDialogAzkar(
    modifier: Modifier = Modifier,
    title: String,
    azkar: String,
    onValueChange: (String) -> Unit,
    onConfirmButtonClicked: () -> Unit,
    onDismissButtonClicked: () -> Unit,
    isError: Boolean
) {

    AlertDialog(
        onDismissRequest = {
            onDismissButtonClicked()
        },
        confirmButton = {
            Text(
                text = stringResource(R.string.confirm),
                modifier = Modifier
                    .padding(8.dp)
                    .testTag("confirm")
                    .clickable {
                        onConfirmButtonClicked()
                    },
                color = Color.Blue,
            )
        },
        dismissButton = {
            Text(
                text = stringResource(R.string.cancel),
                modifier = Modifier
                    .padding(8.dp)
                    .testTag("cancel")
                    .clickable {
                        onDismissButtonClicked()
                    },
                color = Color.Red,
            )
        },
        title = {
            Text(
                text = title,
                color = Color.Black
            )
        },
        text = {
            OutlinedTextField(
                value = azkar,
                onValueChange = {
                    onValueChange(it)
                },
                modifier = modifier
                    .fillMaxWidth()
                    .padding(7.dp)
                    .testTag("addNewZkr"),
                placeholder = {
                    Text(text = stringResource(R.string.add_azkar))
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.DarkGray,
                    unfocusedBorderColor = Color.DarkGray,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    cursorColor = Color.Black

                ),
                maxLines = 1,
                isError = isError
            )
        },
        shape = RoundedCornerShape(9.dp),
        containerColor = Color.White,
        modifier = modifier
            .testTag("alertDialog")

    )
}