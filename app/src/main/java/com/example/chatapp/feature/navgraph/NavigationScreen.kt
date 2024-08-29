package com.example.chatapp.feature.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chatapp.feature.auth.signin.SignInScreen
import com.example.chatapp.feature.auth.signup.SignUpScreen
import com.example.chatapp.feature.home.HomeScreen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

@Composable
fun NavScreen(){
    val navController= rememberNavController()
    val currentUser = FirebaseAuth.getInstance().currentUser
    val start = if (currentUser != null) "home" else "login"
    NavHost(navController = navController, startDestination = start) {
        composable("signin"){
            SignInScreen(navController)
        }
        composable("signup"){
            SignUpScreen(navController)
        }
    composable("home"){
        HomeScreen(navController)
    }
    }
}