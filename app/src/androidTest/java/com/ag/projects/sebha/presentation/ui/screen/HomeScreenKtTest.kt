package com.ag.projects.sebha.presentation.ui.screen

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.ag.projects.sebha.presentation.ui.theme.SebhaTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class HomeScreenKtTest{

    @get:Rule
    val composeRule = createComposeRule()

    @Before
    fun setUp(){
        composeRule.setContent {
            SebhaTheme {
                HomeScreen()
            }
        }
    }

    @Test
    fun whenClickOnFABShowAlertDialogTest(){

        composeRule
            .onNodeWithContentDescription("Add")
            .performClick()

        composeRule
            .onNodeWithTag("alertDialog")
            .assertIsDisplayed()
    }

    @Test
    fun afterClickOnCancelHideAlertDialog(){

        composeRule
            .onNodeWithContentDescription("Add")
            .performClick()

        composeRule
            .onNodeWithTag("alertDialog")
            .assertIsDisplayed()

        composeRule
            .onNodeWithTag("cancel")
            .performClick()

        composeRule
            .onNodeWithTag("alertDialog")
            .assertIsNotDisplayed()
    }

    @Test
    fun afterClickOnConfirmBtnAlertSaveToDB(){

        composeRule
            .onNodeWithContentDescription("Add")
            .performClick()

        composeRule
            .onNodeWithTag("alertDialog")
            .assertIsDisplayed()

        //add a value
        composeRule
            .onNodeWithTag("addNewZkr")
            .performTextInput("123456")

        composeRule
            .onNodeWithTag("confirm")
            .performClick()

        composeRule
            .onNodeWithTag("alertDialog")
            .assertIsNotDisplayed()

    }

    @Test
    fun showErrorIfUserValueIsEmpty(){

        composeRule
            .onNodeWithContentDescription("Add")
            .performClick()

        composeRule
            .onNodeWithTag("alertDialog")
            .assertIsDisplayed()

        composeRule
            .onNodeWithTag("addNewZkr")
            .performTextInput("            ")

        composeRule
            .onNodeWithTag("confirm")
            .performClick()

        composeRule
            .onNodeWithTag("alertDialog")
            .assertIsDisplayed()
    }
}