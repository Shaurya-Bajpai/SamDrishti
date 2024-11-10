package com.example.samdristi.SingupScreen

// SignUpViewModel.kt
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State

class SignUpViewModel : ViewModel() {
    private val _firstName = mutableStateOf("")
    val firstName: State<String> = _firstName

    private val _email = mutableStateOf("")
    val email: State<String> = _email

    private val _password = mutableStateOf("")
    val password: State<String> = _password

    private val _pincode = mutableStateOf("")
    val pincode: State<String> = _pincode

    private val _name = mutableStateOf("")
    val name: State<String> = _name

    private val _govemail = mutableStateOf("")
    val govemail: State<String> = _govemail

    private val _pass = mutableStateOf("")
    val pass: State<String> = _pass

    private val _govId = mutableStateOf("")
    val govId: State<String> = _govId

    fun onFirstNameChange(newName: String) {
        _firstName.value = newName
    }

    fun onEmailChange(newName: String) {
        _email.value = newName
    }

    fun onPasswordChange(newDate: String) {
        _password.value = newDate
    }

    fun onPincodeChange(newGender: String) {
        _pincode.value = newGender
    }

    fun onNameChange(newGender: String) {
        _name.value = newGender
    }

    fun onGovEmailChange(newGender: String) {
        _govemail.value = newGender
    }

    fun onGovPassChange(newGender: String) {
        _pass.value = newGender
    }

    fun onGovIdChange(newGender: String) {
        _govId.value = newGender
    }
}
