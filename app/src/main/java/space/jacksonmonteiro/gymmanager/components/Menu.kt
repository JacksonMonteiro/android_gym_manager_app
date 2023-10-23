package space.jacksonmonteiro.gymmanager.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import space.jacksonmonteiro.gymmanager.data.models.BottomNavigationItem


/*
Created By Jackson Monteiro on 23/10/2023
*/

@Composable
fun Menu(items: List<BottomNavigationItem>) {
    var selectedItem by rememberSaveable() {
        mutableStateOf(0)
    }


    NavigationBar() {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                label = {
                    Text(item.title)
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary
                ),
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    item.action()
                },
                icon = {
                    Icon(
                        imageVector = if (index == selectedItem) {
                            item.selectedIcon
                        } else item.unselectedIcon,
                        contentDescription = item.title
                    )
                }
            )
        }
    }
}