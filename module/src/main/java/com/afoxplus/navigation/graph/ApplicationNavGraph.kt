package com.afoxplus.navigation.graph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.afoxplus.navigation.dispatcher.NavigatorDispatcher
import com.afoxplus.navigation.handler.NavigationHandler

@Composable
fun ApplicationNavGraph(
    modifier: Modifier = Modifier,
    navigatorDispatcher: NavigatorDispatcher,
    navigationHandler: NavigationHandler
) {
    val navController = rememberNavController()
    val graph = navigationHandler.getGraph(navController)
    LaunchedEffect(navController) {
        navigatorDispatcher.bind(navController)
    }

    DisposableEffect(Unit) {
        onDispose {
            navigatorDispatcher.unbind()
        }
    }
    NavHost(modifier = modifier, navController = navController, graph = graph)
}