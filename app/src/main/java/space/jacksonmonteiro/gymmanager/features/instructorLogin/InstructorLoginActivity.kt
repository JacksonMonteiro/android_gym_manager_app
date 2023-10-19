package space.jacksonmonteiro.gymmanager.features.instructorLogin

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import space.jacksonmonteiro.gymmanager.components.*
import space.jacksonmonteiro.gymmanager.features.instructorRegistering.InstructorRegisteringActivity
import space.jacksonmonteiro.gymmanager.ui.theme.GymManagerTheme

class InstructorLoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GymManagerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
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
                                    finish()
                                })
                            }
                            Column {
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
                                    label = "E-mail",
                                    modifier = null,
                                    keyboard = null,
                                    onValueChange = {}
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                                PasswordInput(
                                    label = "Senha",
                                    modifier = null,
                                    keyboard = KeyboardOptions(keyboardType = KeyboardType.Password),
                                    onValueChange = {}
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                                Button(
                                    text = "Login",
                                    containerColor = MaterialTheme.colorScheme.primary,
                                    contentColor = Color.Black,
                                    action = {

                                    })
                            }
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        val navigation = Intent(
                                            this@InstructorLoginActivity,
                                            InstructorRegisteringActivity::class.java
                                        )
                                        startActivity(navigation)

                                    }, horizontalArrangement = Arrangement.Center
                            ) {
                                Text(text = buildAnnotatedString {
                                    append("Não tem uma conta? ")
                                    withStyle(
                                        SpanStyle(
                                            color = MaterialTheme.colorScheme.primary,
                                            fontWeight = FontWeight.Bold
                                        )
                                    ) {
                                        append("Clique aqui e cadastre-se")
                                    }
                                })
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ScreenPreview() {
    GymManagerTheme {
        InstructorLoginActivity()
    }
}