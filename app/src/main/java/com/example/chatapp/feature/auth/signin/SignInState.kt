package com.example.chatapp.feature.auth.signin

sealed class SignInState{
    object Nothing: SignInState()
    object Loading: SignInState()
    object Success: SignInState()
    object Error: SignInState()
}