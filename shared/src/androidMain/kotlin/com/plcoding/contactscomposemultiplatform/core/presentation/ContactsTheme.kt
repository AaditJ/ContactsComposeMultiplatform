package com.plcoding.contactscomposemultiplatform.core.presentation

import android.os.Build
import androidx.compose.runtime.Composable

@Composable
actual fun ContactsTheme(
    darkTheme: Boolean,
    dynamicColor: Boolean,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S

    }

}