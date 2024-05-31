package com.example.moviesapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.moviesapp.routes.MovieRoutes
import com.example.moviesapp.screens.details.DetailsScreen
import com.example.moviesapp.screens.home.HomeScreen

@Composable
fun MovieNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MovieRoutes.HomeScreen.name) {
        composable(MovieRoutes.HomeScreen.name){
            HomeScreen(navController = navController)
        }
        composable(MovieRoutes.DetailScreen.name){
            DetailsScreen(navController = navController)
        }
    }
}