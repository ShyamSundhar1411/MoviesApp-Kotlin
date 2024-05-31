package com.example.moviesapp.routes

enum class MovieRoutes{
    HomeScreen,
    DetailScreen;
    companion object{
        fun fromRoute(route: String?): MovieRoutes = when (
            route?.substringBefore("/")){
            HomeScreen.name -> HomeScreen
            DetailScreen.name -> DetailScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognized");
        }

    }
}