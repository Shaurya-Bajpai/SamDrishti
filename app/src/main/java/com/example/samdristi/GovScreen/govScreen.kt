package com.example.samdristi.GovScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.samdristi.mainScreen.FeatureCards
import com.example.samdristi.mainScreen.NewsSection
import com.example.samdristi.mainScreen.SmartCityViewModel
import com.example.samdristi.ui.theme.back


@Composable
fun GovScreen(paddingValues: PaddingValues, viewModel: SmartCityViewModel, navController: NavController) {

    Text("yo")
    Box(modifier = Modifier.fillMaxSize()) { // Use Box for overlay
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(back),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            GovFeatureCards(navController = navController) // Pass navController
            NewsSection(viewModel)
        }
    }
}