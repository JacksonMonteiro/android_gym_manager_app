package space.jacksonmonteiro.gymmanager.features.settings

import android.annotation.SuppressLint
import android.os.Bundle
import android.window.OnBackInvokedDispatcher
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import space.jacksonmonteiro.gymmanager.components.BottomNavigationItem
import space.jacksonmonteiro.gymmanager.components.Button
import space.jacksonmonteiro.gymmanager.components.Menu
import space.jacksonmonteiro.gymmanager.ui.theme.GymManagerTheme

class SettingsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen() {
    GymManagerTheme {
        /*val items = listOf<BottomNavigationItem>(
            BottomNavigationItem(
                title = "Alunos",
                selectedIcon = Icons.Filled.Person,
                unselectedIcon = Icons.Outlined.Person,
                action = {}
            ),
            BottomNavigationItem(
                title = "Configurações",
                selectedIcon = Icons.Filled.Settings,
                unselectedIcon = Icons.Outlined.Settings,
                action = {}
            ),
        )

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Scaffold(
                bottomBar = {
                    Menu(items = items)
                }
            ) {

            }
        }*/

        Box(
            modifier = Modifier.padding(all = 16.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        text = "Sair",
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = Color.Black
                    ) {

                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewScreen() {
    GymManagerTheme {
        SettingsActivity()
    }
}