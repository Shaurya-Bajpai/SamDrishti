package com.example.samdristi.SingupScreen

// SignUpScreen.kt
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.samdristi.ui.theme.back
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GovSignUp(navController: NavController, viewModel: SignUpViewModel) {
    val name by viewModel.name
    val email by viewModel.govemail
    val password by viewModel.pass
    val govid by viewModel.govId

    var isLoading by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val auth = FirebaseAuth.getInstance()
    val db = FirebaseFirestore.getInstance()

    var isError by rememberSaveable { mutableStateOf(false) }

    fun validate(text: String) {
        isError = text.length != 6
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(back)

    ) {
        // Display the top image
//        Image(
//            painter = painterResource(id = R.drawable.singupscreen), // Add your drawable resource here
//            contentDescription = "Sign Up Image",
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(150.dp)
//        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Sign In", color = Color.White, fontSize = 32.sp)

        Spacer(modifier = Modifier.height(3.dp))

        // First Name Field
        TextField(
            value = name,
            onValueChange = { viewModel.onNameChange(it) },
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
            placeholder = { Text("Name") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        )

        Spacer(modifier = Modifier.height(3.dp))

        // Last Name Field
        TextField(
            value = email,
            onValueChange = { viewModel.onGovEmailChange(it) },
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

        Spacer(modifier = Modifier.height(3.dp))

        var passwordVisible by rememberSaveable { mutableStateOf(false) }

        // Date of Birth Field
        TextField(
            value = password,
            onValueChange = { viewModel.onGovPassChange(it) },
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
                imeAction = ImeAction.Next
            ),
            trailingIcon = {
//                val image =
//                    if (passwordVisible) painterResource(id = R.drawable.baseline_visibility_24)
//                    else painterResource(id = R.drawable.baseline_visibility_off_24)

                // Please provide localized description for accessibility services
                val description =
                    if (passwordVisible) "Hide password" else "Show password"

//                IconButton(onClick = { passwordVisible = !passwordVisible }) {
//                    Icon(painter = image, description)
//                }
            },
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        )

        Spacer(modifier = Modifier.height(3.dp))

        // Gender Field
        TextField(
            value = govid,
            onValueChange = {
                viewModel.onGovIdChange(it)
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
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
            placeholder = { Text("Gov id") },
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Button to navigate to the next screen

        Button(
            onClick = {
                // Store user data in Firestore
                val userData = hashMapOf(
                    "firstName" to viewModel.name.value,
                    "email" to viewModel.govemail.value,
                    "password" to viewModel.password.value,
                    "pincode" to viewModel.pincode.value,
                )
                db.collection("users")
                    .document(auth.currentUser?.uid ?: "UnknownUser")
                    .set(userData)
                    .addOnSuccessListener {
                        Toast.makeText(context, "User data stored successfully", Toast.LENGTH_SHORT)
                            .show()
                    }
                    .addOnFailureListener { e ->
                        Toast.makeText(
                            context,
                            "Failed to store data: ${e.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                navController.navigate("mainContent")
            },
            colors = ButtonDefaults.buttonColors(Blue)
        ) {
            Text(
                text = if (isLoading) "Signing Up..." else "Sign Up",
                modifier = Modifier.padding(horizontal = 40.dp),
                color = Color.White,
//                    fontWeight = FontWeight.Bold
            )
        }
    }
}