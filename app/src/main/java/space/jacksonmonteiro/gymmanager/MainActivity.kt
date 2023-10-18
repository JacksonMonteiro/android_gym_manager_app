package space.jacksonmonteiro.gymmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import space.jacksonmonteiro.gymmanager.features.home.HomeActivity
import space.jacksonmonteiro.gymmanager.features.instructorLogin.InstructorLoginActivity
import space.jacksonmonteiro.gymmanager.features.instructorRegistering.InstructorRegisteringScreen
import space.jacksonmonteiro.gymmanager.utils.Routes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Routes.home) {
                composable(route = Routes.home) {
                    HomeActivity(navController)
                }

                composable(route = Routes.instructorLogin) {
                    InstructorLoginActivity(navController)
                }

                composable(route = Routes.instructorRegistering) {
                    InstructorRegisteringScreen(navController)
                }
            }
        }
    }
}
