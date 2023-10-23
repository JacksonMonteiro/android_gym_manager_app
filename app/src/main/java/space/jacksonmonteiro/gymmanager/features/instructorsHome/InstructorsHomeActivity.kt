package space.jacksonmonteiro.gymmanager.features.instructorsHome

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import space.jacksonmonteiro.gymmanager.MainActivity
import space.jacksonmonteiro.gymmanager.components.BottomNavigationItem
import space.jacksonmonteiro.gymmanager.components.Menu
import space.jacksonmonteiro.gymmanager.features.settings.SettingsScreen
import space.jacksonmonteiro.gymmanager.ui.theme.GymManagerTheme
import space.jacksonmonteiro.gymmanager.utils.Routes

class InstructorsHomeActivity : ComponentActivity(), InstructorsHomeContract.View {
    private val presenter = InstructorsHomePresenter()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter.view = this

        setContent {
            GymManagerTheme {
                val navController = rememberNavController()

                val items = listOf<BottomNavigationItem>(
                    BottomNavigationItem(
                        title = "Alunos",
                        selectedIcon = Icons.Filled.Person,
                        unselectedIcon = Icons.Outlined.Person,
                        action = {
                            navController.navigate(Routes.home)
                        }
                    ),
                    BottomNavigationItem(
                        title = "Configurações",
                        selectedIcon = Icons.Filled.Settings,
                        unselectedIcon = Icons.Outlined.Settings,
                        action = {
                            navController.navigate(Routes.settings)
                        }
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
                        NavHost(navController = navController, startDestination = Routes.home) {
                            composable(Routes.home) {
                                Box(
                                    modifier = Modifier.padding(all = 16.dp)
                                ) {
                                    Column {

                                    }
                                }
                            }

                            composable(Routes.settings) {
                                SettingsScreen()
                            }
                        }
                    }
                }
            }
        }
    }

    override fun exit() {
        val navigation = Intent(this@InstructorsHomeActivity, MainActivity::class.java)
        navigation.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(navigation)
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    GymManagerTheme {
        InstructorsHomeActivity()
    }
}