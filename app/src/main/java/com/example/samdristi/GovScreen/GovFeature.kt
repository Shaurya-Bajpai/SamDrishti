package com.example.samdristi.GovScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.samdristi.mainScreen.FeatureCard

@Composable
fun GovFeatureCards(navController: NavController) {
    val screenHeight = LocalConfiguration.current.screenHeightDp
    val top40Height = (screenHeight * 0.4).dp  // 40% of screen height

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.4f)
            .padding(0.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        FeatureCard("Citizen's Sentiment", modifier = Modifier.padding(50.dp)){
            navController.navigate("sentimentScreen")
        }
    }
}