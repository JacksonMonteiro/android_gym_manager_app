package space.jacksonmonteiro.gymmanager.features.instructorsHome

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import space.jacksonmonteiro.gymmanager.MainActivity
import space.jacksonmonteiro.gymmanager.components.BottomNavigationItem
import space.jacksonmonteiro.gymmanager.components.Button
import space.jacksonmonteiro.gymmanager.ui.theme.GymManagerTheme

class InstructorsHomeActivity : ComponentActivity(), InstructorsHomeContract.View {
    private val presenter = InstructorsHomePresenter()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter.view = this

        setContent {
            GymManagerTheme {
                val items = listOf<BottomNavigationItem>(
                    BottomNavigationItem(
                        title = "Alunos",
                        selectedIcon = Icons.Filled.Person,
                        unselectedIcon = Icons.Outlined.Person,
                    )
                )

                var selectedItem by rememberSaveable() {
                    mutableStateOf(0)
                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        bottomBar = {
                            NavigationBar() {
                                items.forEachIndexed { index, item ->
                                    NavigationBarItem(
                                        selected = selectedItem == index,
                                        onClick = {
                                            selectedItem = index
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
                    ) {
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
                                        presenter.logout()
                                    }
                                }
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