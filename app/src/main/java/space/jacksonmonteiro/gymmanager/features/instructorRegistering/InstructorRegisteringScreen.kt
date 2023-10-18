package space.jacksonmonteiro.gymmanager.features.instructorRegistering

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.compose.GymManagerTheme
import space.jacksonmonteiro.gymmanager.components.*


/*
Created By Jackson Monteiro on 17/10/2023
Copyright (c) 2023 GFX Consultoria
*/


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun InstructorRegisteringScreen(navController: NavController) {
    GymManagerTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = MaterialTheme.colorScheme.background,
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = 12.dp),
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        ReturnButton(action = {
                            navController.popBackStack()
                        })
                    }
                    Column() {
                        Message(
                            message = "Insira os dados da sua conta para fazer login",
                            fontSize = 22.sp,
                            color = null,
                            fontWeight = null,
                            textAlign = TextAlign.Start,
                            modifier = null,
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        TextInput(
                            label = "Nome",
                            modifier = null,
                            keyboard = null,
                            isPasswordField = false
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        TextInput(
                            label = "E-mail",
                            modifier = null,
                            keyboard = null,
                            isPasswordField = false,
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        PasswordInput(
                            label = "Senha",
                            modifier = null,
                            keyboard = KeyboardOptions(keyboardType = KeyboardType.Password),
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        PasswordInput(
                            label = "Confirme sua senha",
                            modifier = null,
                            keyboard = KeyboardOptions(keyboardType = KeyboardType.Password),
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            text = "Criar conta",
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = Color.Black,
                            action = {

                            }
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    GymManagerTheme {
        InstructorRegisteringScreen(navController = rememberNavController())
    }
}
