package com.afoxplus.navigation.handler

import com.afoxplus.navigation.model.NavigatorOptions

interface NavigatorHandler {
    fun <T : Any> navigate(route: T, options: NavigatorOptions)
    fun <T : Any> popBackStack(route: T, inclusive: Boolean, saveState: Boolean = false) : Boolean
    fun popBackStack(): Boolean
}