/*
package space.jacksonmonteiro.gymmanager.features.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import space.jacksonmonteiro.gymmanager.ui.theme.GymManagerTheme
import space.jacksonmonteiro.gymmanager.R
import space.jacksonmonteiro.gymmanager.components.Button
import space.jacksonmonteiro.gymmanager.components.Message
import space.jacksonmonteiro.gymmanager.utils.Routes


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeActivity(navController: NavController) {
    GymManagerTheme() {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = Color.Black
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.background),
                    contentDescription = "Background",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .fillMaxSize()
                        .alpha(0.75f)
                )

                Column(
                    modifier = Modifier
                        .padding(all = 12.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Message(
                        "Seja Bem-Vindo!",
                        fontSize = 32.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )
                    Button(
                        text = "Sou Instrutor",
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = Color.Black,
                        action = {
                            navController.navigate(Routes.instructorLogin) {
                                popUpTo(Routes.home)
                            }
                        }

                    )
                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )
                    Button("Sou Aluno", Color(0xFFFFFFFF), Color.Black, {})
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    GymManagerTheme {
        HomeActivity(rememberNavController())
    }
}*/
