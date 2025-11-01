package com.afoxplus.navigation.handler

import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.createGraph
import com.afoxplus.navigation.provider.NavigationProvider
import com.afoxplus.navigation.routers.SplashRoute
import javax.inject.Inject

class NavigationHandler @Inject constructor(private val navigationProvider: NavigationProvider) {
    fun getGraph(navController: NavController): NavGraph {
        return navController.createGraph(startDestination = SplashRoute) {
            navigationProvider.getNavigationEntries().forEach { entry ->
                with(entry) { register(navController) }
            }
        }
    }
}