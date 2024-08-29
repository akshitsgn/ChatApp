package com.example.chatapp.feature.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chatapp.feature.auth.signin.SignInScreen
import com.example.chatapp.feature.auth.signup.SignUpScreen

@Composable
fun NavScreen(){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = "signin") {
        composable("signin"){
            SignInScreen(navController)
        }
        composable("signup"){
            SignUpScreen(navController)
        }

    }
}