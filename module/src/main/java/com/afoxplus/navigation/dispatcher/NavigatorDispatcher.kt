package com.afoxplus.navigation.dispatcher

import androidx.navigation.NavController
import com.afoxplus.navigation.handler.NavigatorHandler
import com.afoxplus.navigation.model.NavigatorOptions
import java.lang.ref.WeakReference
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NavigatorDispatcher @Inject constructor() : NavigatorHandler {
    private var navControllerRef: WeakReference<NavController>? = null

    private val navController: NavController?
        get() = navControllerRef?.get()

    fun bind(navController: NavController) {
        navControllerRef = WeakReference(navController)
    }

    fun unbind() {
        navControllerRef = null
    }

    override fun <T : Any> navigate(route: T, options: NavigatorOptions) {
        val controller = navController ?: return
        controller.navigate(route) {
            launchSingleTop = options.launchSingleTop
            restoreState = options.restoreState
            options.popUpTo?.let {
                popUpTo(it.destination) {
                    saveState = it.savedState
                    inclusive = it.inclusive
                }
            }
        }
    }

    override fun <T : Any> popBackStack(route: T, inclusive: Boolean, saveState: Boolean): Boolean {
        val controller = navController ?: return false
        return controller.popBackStack(route, inclusive, saveState)

    }

    override fun popBackStack(): Boolean {
        val controller = navController ?: return false
        return controller.popBackStack()
    }

}