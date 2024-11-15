package com.example.samdristi.mainScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.samdristi.ui.theme.back

@Composable
fun MainContent(paddingValues: PaddingValues, viewModel: SmartCityViewModel , navController: NavController) {

    Box(modifier = Modifier.fillMaxSize()) { // Use Box for overlay
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(back),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            FeatureCards(navController = navController) // Pass navController
            NewsSection(viewModel)
        }
    }
}