package space.jacksonmonteiro.gymmanager.features.instructorRegistering

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AlertDialog
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import space.jacksonmonteiro.gymmanager.components.*
import space.jacksonmonteiro.gymmanager.ui.theme.GymManagerTheme


class InstructorRegisteringActivity : ComponentActivity(), InstructorRegisteringContract.View {
    private val presenter = InstructorRegisteringPresenter()

    private var name: String = ""
    private var email: String = ""
    private var password: String = ""
    private var confirmedPassword: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter.view = this

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
                                    label = "Nome",
                                    modifier = null,
                                    keyboard = null,
                                    onValueChange = { value ->
                                        name = value
                                    }
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                                TextInput(
                                    label = "E-mail",
                                    modifier = null,
                                    keyboard = null,
                                    onValueChange = { value ->
                                        email = value
                                    }
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                                PasswordInput(
                                    label = "Senha",
                                    modifier = null,
                                    keyboard = KeyboardOptions(keyboardType = KeyboardType.Password),
                                    onValueChange = { value ->
                                        password = value
                                    }
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                                PasswordInput(
                                    label = "Confirme sua senha",
                                    modifier = null,
                                    keyboard = KeyboardOptions(keyboardType = KeyboardType.Password),
                                    onValueChange = { value ->
                                        confirmedPassword = value
                                    }
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                                Button(
                                    text = "Criar conta",
                                    containerColor = MaterialTheme.colorScheme.primary,
                                    contentColor = Color.Black,
                                    action = {
                                        presenter.register(name, email, password, confirmedPassword)
                                    }
                                )
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }
                }
            }
        }
    }


    override fun showFailure(message: String) {
        AlertDialog.Builder(this)
            .setTitle("Erro")
            .setMessage(message)
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    override fun showSuccess(message: String) {
        AlertDialog.Builder(this)
            .setTitle("Sucesso!")
            .setMessage(message)
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .show()

    }
}

@Preview
@Composable
fun ScreenPreview() {
    GymManagerTheme {
        InstructorRegisteringActivity()
    }
}
