package com.example.chatapp.feature.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController){
    val viewModel: HomeViewModel= hiltViewModel()
    val channels = viewModel.channels.collectAsState()
    Log.d("check", channels.toString())
    Scaffold {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
 LazyColumn {
items(channels.value){ channel->
    Column {
        Text(text = channel.name, modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp))
            }
          }
        }
      }
    }
}
