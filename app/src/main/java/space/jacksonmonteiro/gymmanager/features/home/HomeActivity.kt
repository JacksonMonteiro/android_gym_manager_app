package space.jacksonmonteiro.gymmanager.features.home

import android.content.Intent
import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import space.jacksonmonteiro.gymmanager.MainActivity
import space.jacksonmonteiro.gymmanager.components.Button
import space.jacksonmonteiro.gymmanager.ui.theme.GymManagerTheme

class HomeActivity : ComponentActivity(), HomeContract.View {
    private val presenter = HomePresenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter.view = this

        setContent {
            GymManagerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box (
                        modifier = Modifier.padding(all = 16.dp)
                            ) {
                        Column {
                            Row (
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Button(text = "Sair", containerColor = MaterialTheme.colorScheme.primary, contentColor = Color.Black) {
                                    presenter.logout()
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    override fun exit() {
        val navigation = Intent(this@HomeActivity, MainActivity::class.java)
        navigation.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(navigation)
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GymManagerTheme {
        HomeActivity()
    }
}