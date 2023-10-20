package space.jacksonmonteiro.gymmanager.components

import androidx.compose.ui.graphics.vector.ImageVector


/*
Created By Jackson Monteiro on 20/10/2023
*/


data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
)