package com.plcoding.contactscomposemultiplatform.core.presentation

import androidx.compose.runtime.Composable

@Composable
expect fun ContactsTheme(
    darkTheme: Boolean,
    dynamicColor: Boolean,
    contene: @Composable () -> Unit
)