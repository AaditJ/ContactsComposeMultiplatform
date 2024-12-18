package com.plcoding.contactscomposemultiplatform

import androidx.compose.ui.window.ComposeUIViewController
import platfrom.UIKit.UIScreen
import platform.UIKit.UIUserInterfaceStyle

fun MainViewController() = ComposeUIViewController {

    val isDarkTheme = UIScreen.main.traitCollection.userInterfaceStyle == UIUserInterfaceStyle.Dark
    App(
        darkTheme = isDarkTheme,
        dynamicColor = false
    ) {

    }
}