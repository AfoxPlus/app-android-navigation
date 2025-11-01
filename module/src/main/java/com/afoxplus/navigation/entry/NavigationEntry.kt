package com.afoxplus.navigation.entry

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

interface NavigationEntry {
    fun NavGraphBuilder.register(navController: NavController)
}