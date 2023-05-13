package com.example.yassirtask.features.movies

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.presentation.movies.contract.MoviesContract
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun MoviesNavGraph(
    navigator: DestinationsNavigator,
    bottomBarNavController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        modifier = modifier,
        navController = bottomBarNavController,
        startDestination = MoviesContract.Navigation.Routes.MY_HOME
    ) {
        composable(
            route = MoviesContract.Navigation.Routes.MY_HOME
        ) {
            MoviesScreen(navigator = navigator)
        }
    }
}
