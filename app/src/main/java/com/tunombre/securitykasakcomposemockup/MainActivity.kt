package com.tunombre.securitykasakcomposemockup // Reemplaza con tu nombre de paquete real

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme // Importa el MaterialTheme base
import androidx.compose.material3.Surface
import androidx.compose.material3.Text // Solo para el ejemplo de Greeting
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

// NO importamos tu tema personalizado por ahora:
// import com.tunombre.securitykasakcomposemockup.ui.theme.SecurityKasakComposeMockupTheme

// Importa tus pantallas (Composable functions)
// Asegúrate que el paquete sea el correcto.
import com.tunombre.securitykasakcomposemockup.WelcomeScreen
import com.tunombre.securitykasakcomposemockup.LoginScreen
import com.tunombre.securitykasakcomposemockup.RegisterScreen
import com.tunombre.securitykasakcomposemockup.DashboardScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Usamos MaterialTheme directamente, SIN tu tema personalizado
            MaterialTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    // Usaremos el color de fondo del MaterialTheme por defecto
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        NavHost(navController = navController, startDestination = "welcome") {
            composable("welcome") {
                WelcomeScreen(navController = navController)
            }
            composable("login") {
                LoginScreen(navController = navController)
            }
            composable("register") {
                RegisterScreen(navController = navController)
            }
            composable("dashboard") {
                DashboardScreen(navController = navController)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    // Para la vista previa, también usamos MaterialTheme directamente
    MaterialTheme {
        // Puedes previsualizar una pantalla específica o toda la navegación
        // WelcomeScreen(navController = rememberNavController())
        AppNavigation()
    }
}