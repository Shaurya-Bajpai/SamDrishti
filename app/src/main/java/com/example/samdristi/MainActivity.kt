package com.example.samdristi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.samdristi.mainScreen.BottomNavigationBar
import com.example.samdristi.mainScreen.MainContent
import com.example.samdristi.mainScreen.SmartCityViewModel
import com.example.samdristi.mainScreen.TopBar
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.samdristi.CivicIssuesChatBot.CivicChatBot
import com.example.samdristi.MentalHealthChatBot.ChatBot
import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.samdristi.ComplainRegistration.ChatbotScreen
import com.example.samdristi.ComplainRegistration.MainViewModel
import com.example.samdristi.DocumetSummerizer.SimplifyScreen
import com.example.samdristi.GovData.InflationScreen
import com.example.samdristi.GovData.InflationViewModel
import com.example.samdristi.LoginScreen.LoginScreen
import com.example.samdristi.LoginScreen.LoginViewModel
import com.example.samdristi.SingupScreen.NextScreen
import com.example.samdristi.SingupScreen.SignUpScreen
import com.example.samdristi.SingupScreen.SignUpViewModel
import com.example.samdristi.mapScreen.MapScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestLocationPermission()
        setContent {
            SmartCityApp()
        }
    }

    private fun requestLocationPermission() {
        val permission = Manifest.permission.ACCESS_FINE_LOCATION
        when {
            ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED -> {
            }
            ActivityCompat.shouldShowRequestPermissionRationale(this, permission) -> {
            }
            else -> {
                requestPermissionLauncher.launch(permission)
            }
        }
    }

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            // Permission is granted, proceed with displaying the map
        } else {
            // Permission is denied, handle accordingly
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmartCityApp(viewModel: SmartCityViewModel = viewModel()) {
    val navController = rememberNavController()
    var showBars by remember { mutableStateOf(true) }
    val loginViewModel: LoginViewModel = viewModel()
    val singupViewModel: SignUpViewModel = viewModel()
    val inflationViewModel : InflationViewModel = viewModel()
    val ChatbotViewModel : MainViewModel = viewModel()


    Scaffold(
        topBar = { if (showBars) TopBar() },
        bottomBar = { if (showBars) BottomNavigationBar() }
    ) { paddingValues ->
        NavHost(navController = navController, startDestination = "LoginScreen") {
            composable("mainContent") {
                showBars = true
                MainContent(paddingValues, viewModel, navController)
            }
            composable("chatBotScreen") {
                showBars = false
                ChatBot()
            }

            composable("CivicIssueChatBot"){
                showBars = false
                CivicChatBot()
            }

            composable("mapScreen") {
                showBars = false
                MapScreen()
            }

            composable("LoginScreen"){
                showBars = false
                LoginScreen(loginViewModel , navController)
            }

            composable("SignupScreen") {
                showBars  = false
                SignUpScreen(navController,singupViewModel)
            }

            composable("NextScreen") {
                showBars = false
                NextScreen(singupViewModel , navController)
            }

            composable("inflationRage") {
                showBars = false
                InflationScreen(navController,inflationViewModel)
            }

            composable("simplifierScreen"){
                showBars = false
                SimplifyScreen()
            }
            composable("ComplainChatbot") {
                showBars = false
                ChatbotScreen(ChatbotViewModel)

            }

        }
    }
}