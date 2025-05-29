package com.tunombre.securitykasakcomposemockup // Reemplaza con tu paquete

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tunombre.securitykasakcomposemockup.ui.theme.LightBackground // Importa tus colores
import com.tunombre.securitykasakcomposemockup.ui.theme.SecurityAppBlue
import com.tunombre.securitykasakcomposemockup.ui.theme.TextOnBlue

@Composable
fun WelcomeScreen(navController: NavController) {
    Surface(modifier = Modifier.fillMaxSize(), color = LightBackground) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Security Kasak",
                fontSize = 32.sp,
                style = MaterialTheme.typography.headlineLarge,
                color = SecurityAppBlue,
                modifier = Modifier.padding(bottom = 48.dp)
            )
            Button(
                onClick = { navController.navigate("login") },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = SecurityAppBlue)
            ) {
                Text("Iniciar Sesión", color = TextOnBlue, fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { navController.navigate("register") },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary) // Un color diferente
            ) {
                Text("Registrarse", color = MaterialTheme.colorScheme.onSecondary, fontSize = 16.sp)
            }
        }
    }
}