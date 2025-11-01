package com.afoxplus.navigation.graph

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.afoxplus.navigation.handler.NavigationHandler

@Composable
fun ApplicationNavGraph(modifier: Modifier = Modifier, navigationHandler: NavigationHandler) {
    val navController = rememberNavController()
    val graph = navigationHandler.getGraph(navController)
    NavHost(modifier = modifier, navController = navController, graph = graph)
}