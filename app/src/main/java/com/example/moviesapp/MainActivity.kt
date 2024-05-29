package com.example.moviesapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moviesapp.components.MovieRow
import com.example.moviesapp.ui.theme.MoviesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp {
                MainContent()
            }
        }
    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp(content: @Composable () -> Unit){
    MoviesAppTheme {
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
                content()
            }
        }
    }
}
@Composable
fun MainContent(movieList: List<String> = listOf(
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
                MovieRow(movie = it)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MyAppPreview(){
    MyApp {
        MainContent()
    }
}