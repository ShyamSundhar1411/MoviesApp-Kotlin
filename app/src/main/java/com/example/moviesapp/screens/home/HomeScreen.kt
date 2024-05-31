package com.example.moviesapp.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.moviesapp.components.MovieRow
import com.example.moviesapp.routes.MovieRoutes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "MoviesApp", textAlign = TextAlign.Center)
            })
        }
    ) {
            innerPadding -> Box(
        modifier = Modifier.padding(innerPadding)
    ){
        MainContent(navController = navController)
    }
    }
}
@Composable
fun MainContent(navController: NavController,movieList: List<String> = listOf(
    "Avatar",
    "300",
    "Harry Potter",
    "Life",
    "Ghost of Tsushima",
    "Boku No Hero Academia",
    "Shingeki No Kyojin",
)){
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items(items = movieList){
                MovieRow(movie = it){
                       movie->navController.navigate(route = MovieRoutes.DetailScreen.name+"/$movie")
                }
            }
        }
    }
}