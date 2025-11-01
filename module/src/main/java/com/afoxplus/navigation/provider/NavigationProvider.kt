package com.afoxplus.navigation.provider

import com.afoxplus.navigation.entry.NavigationEntry
import javax.inject.Inject

class NavigationProvider @Inject constructor(
    private val navigationEntries: Set<@JvmSuppressWildcards NavigationEntry>
) {
    fun getNavigationEntries(): Set<NavigationEntry> = navigationEntries
}