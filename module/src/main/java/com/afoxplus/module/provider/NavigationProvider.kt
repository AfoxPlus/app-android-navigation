package com.afoxplus.module.provider

import com.afoxplus.module.entry.NavigationEntry
import javax.inject.Inject

class NavigationProvider @Inject constructor(
    private val navigationEntries: Set<@JvmSuppressWildcards NavigationEntry>
) {
    fun getNavigationEntries(): Set<NavigationEntry> = navigationEntries
}