package space.jacksonmonteiro.gymmanager

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import com.google.firebase.auth.FirebaseAuth
import space.jacksonmonteiro.gymmanager.components.Button
import space.jacksonmonteiro.gymmanager.components.Message
import space.jacksonmonteiro.gymmanager.features.instructorLogin.InstructorLoginActivity
import space.jacksonmonteiro.gymmanager.features.instructorsHome.InstructorsHomeActivity
import space.jacksonmonteiro.gymmanager.ui.theme.GymManagerTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GymManagerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
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
                                    val navigation = Intent(
                                        this@MainActivity,
                                        InstructorLoginActivity::class.java
                                    )
                                    startActivity(navigation)
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
    }

    override fun onStart() {
        super.onStart()

        // Veifiy user session, if already logged in, redirect to home screen
        val auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser
        if (currentUser != null) {
            val navigation = Intent(this@MainActivity, InstructorsHomeActivity::class.java)
            navigation.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(navigation)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    GymManagerTheme {
        MainActivity()
    }
}