package com.example.samdristi.LoginScreen

// LoginScreen.kt
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.samdristi.R
import com.example.samdristi.ui.theme.back

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(viewModel: LoginViewModel , navController: NavController) {
    var emailsign by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val loginStatus by viewModel.loginStatus.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(back)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
//        Image(
//            painter = painterResource(id = R.drawable.welcome_image),
//            contentDescription = "Welcome Image",
//            modifier = Modifier.size(200.dp)
//        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Login",
            color = Color.White,
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = emailsign,
            onValueChange = { emailsign = it },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.LightGray,
                unfocusedIndicatorColor = Color.LightGray,
                disabledIndicatorColor = Color.LightGray,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                cursorColor = Color.White,
                containerColor = Color.Transparent,
                focusedPlaceholderColor = Color.LightGray,
                unfocusedLabelColor = Color.LightGray
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            placeholder = { Text("Email") },
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        )


    Spacer(Modifier.height(16.dp))
        var passwordVisible by rememberSaveable { mutableStateOf(false) }

        // Date of Birth Field
        TextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text("Password") },
            singleLine = true,
            visualTransformation = if (passwordVisible) VisualTransformation.None
            else PasswordVisualTransformation(),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.LightGray,
                unfocusedIndicatorColor = Color.LightGray,
                disabledIndicatorColor = Color.LightGray,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                cursorColor = Color.White,
                containerColor = Color.Transparent,
                focusedPlaceholderColor = Color.LightGray,
                unfocusedLabelColor = Color.LightGray,
                disabledPlaceholderColor = Color.LightGray
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            trailingIcon = {
                val image =
                    if (passwordVisible) painterResource(id = R.drawable.baseline_visibility_24)
                    else painterResource(id = R.drawable.baseline_visibility_off_24)

//                 Please provide localized description for accessibility services
                val description =
                    if (passwordVisible) "Hide password" else "Show password"

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(painter = image, description)
                }
            },
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))

//        Text(
//            text = "Forgot Password? Click me",
//            color = Color.White,
//            modifier = Modifier.padding(vertical = 8.dp)
//        )

        Button(
            onClick = {
//                viewModel.login(emailsign, password)
                navController.navigate("mainContent")
            },
            colors = ButtonDefaults.buttonColors(Blue),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(text = "Login")
        }

        Spacer(modifier = Modifier.height(8.dp))

        ClickableText(
            text = AnnotatedString("Don't have an account? SignUp"),
            onClick = { navController.navigate("SignScreen") },
            style = LocalTextStyle.current.copy(color = Color.White)
        )

        // Handle login status
        when (loginStatus) {
            is LoginStatus.Success -> Text("Login Successful", color = Color.Green)
            is LoginStatus.Failure -> Text("Login Failed: ${(loginStatus as LoginStatus.Failure).message}", color = Color.Red)
            else -> {}
        }
    }
}
