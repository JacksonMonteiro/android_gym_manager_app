package space.jacksonmonteiro.gymmanager.features.settings

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import space.jacksonmonteiro.gymmanager.components.BlockOnBackPress
import space.jacksonmonteiro.gymmanager.components.Button
import space.jacksonmonteiro.gymmanager.ui.theme.GymManagerTheme


class SettingsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SettingsScreen()
        }
    }


}

@Composable
fun SettingsScreen() {
    BlockOnBackPress()

    GymManagerTheme {
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
        SettingsScreen()
    }
}

