package com.example.samdristi.SingupScreen

// SignUpScreen.kt
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.samdristi.ui.theme.back

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .background(back)
            .padding(30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){


        Text(
            text = "Sign Up",
            color = Color.White,
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )

        Button(
            onClick = {
                navController.navigate("SignupScreen")
            },
            colors = ButtonDefaults.buttonColors(Blue)
        ) {
            Text(
                text = "Sign Up as Citizen",
                modifier = Modifier.padding(horizontal = 40.dp),
                color = Color.White,
//                    fontWeight = FontWeight.Bold
            )
        }
        
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                navController.navigate("GovScreen")
            },
            colors = ButtonDefaults.buttonColors(Blue)
        ) {
            Text(
                text = "Sign Up as Govn Employee",
                modifier = Modifier.padding(horizontal = 40.dp),
                color = Color.White,
//                    fontWeight = FontWeight.Bold
            )
        }
    }
}