package com.example.chatapp.feature.auth.signin

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.chatapp.R
import com.example.chatapp.ui.theme.Purple40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(navController: NavController){
    val gradientBrush = Brush.verticalGradient(
        colors = listOf(Color(0xFF5885af), Color(0xFFBFD7ED), Color(0xFFc3e0e5),  )
    )
    var name by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    var confirm by remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(0.dp)
        .background(Color(0xFFfde6d6)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){

        Text("Login", modifier = Modifier.padding(10.dp,0.dp,10.dp,15.dp), fontSize = 29.sp, fontWeight = FontWeight.Medium,)
        Spacer(modifier = Modifier.height(12.dp))
        Text("Hello, welcome back", fontSize = 18.sp,)
        Spacer(modifier = Modifier.height(19.dp))

        OutlinedTextField(
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Toggle password visibility",
                    tint = Color.DarkGray
                )
            },
            value = name,
            onValueChange = { name= it },
            label = { Text("Username") },
            modifier = Modifier
                .height(60.dp)
                .width(350.dp)// Adjust the width as needed
                .background(Color.White, shape = RoundedCornerShape(22.dp)),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent, // Ensure the background color is applied from Modifier.background
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(12.dp) // Ensure the shape is applied
        )
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "Toggle password visibility",
                    tint = Color.DarkGray
                )
            },
            value = password,
            visualTransformation = PasswordVisualTransformation(),
            onValueChange = {password= it },
            label = { Text("Password") },
            modifier = Modifier
                .height(60.dp)
                .width(350.dp) // Adjust the width as needed
                .background(Color.White, shape = RoundedCornerShape(22.dp)),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent, // Ensure the background color is applied from Modifier.background
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(42.dp)// Ensure the shape is applied
        )
        Spacer(modifier = Modifier.height(12.dp))
        Button(
            onClick = { /* Handle button click */ },
            modifier = Modifier.
                width(300.dp)
                .padding(16.dp),
            enabled = name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF6A0D91), // Set button color
                contentColor = Color.White // Set text color
            ),
            shape = RoundedCornerShape(12.dp) // Ensure button has rounded corners
        ) {
            Text("Log in") // Button text
        }
        Row {
            Text("Doesn't have a account?",
                fontSize = 18.sp,)
            Text(" Sign Up",
                fontWeight = FontWeight.Medium,
                modifier = Modifier.clickable {
                    navController.navigate("signup")
                },
                fontSize = 18.sp,
                color = Color.Blue)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSignInScreen() {
    val navController= rememberNavController()
    SignInScreen(navController)
}