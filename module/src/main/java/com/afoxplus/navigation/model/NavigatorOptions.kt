package com.afoxplus.navigation.model

class NavigatorOptions(
    val launchSingleTop: Boolean,
    val restoreState: Boolean,
    val popUpTo: PopUpTo?
) {
    class Builder() {
        private var _launchSingleTop: Boolean = false
        private var _restoreState: Boolean = false
        private var _popUpTo: PopUpTo? = null


        fun setLaunchSingleTop(launchSingleTop: Boolean) = apply {
            this._launchSingleTop = launchSingleTop
        }

        fun setRestoreState(restoreState: Boolean) = apply {
            this._restoreState = restoreState
        }

        fun setPopUpTo(popUpTo: PopUpTo) = apply {
            this._popUpTo = popUpTo
        }

        fun build(): NavigatorOptions =
            NavigatorOptions(
                launchSingleTop = _launchSingleTop,
                restoreState = _restoreState,
                popUpTo = _popUpTo
            )

    }
}