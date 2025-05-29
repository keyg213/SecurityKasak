package com.tunombre.securitykasakcomposemockup // Reemplaza con tu nombre de paquete real

import android.widget.Toast // Necesario para el mensaje de error
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext // Necesario para el Toast
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

// --- Tus Colores (Asegúrate de que este paquete sea correcto si usas Color.kt) ---
// Necesarios si personalizas el fondo, título, ícono o botones.
import com.tunombre.securitykasakcomposemockup.ui.theme.LightBackground
import com.tunombre.securitykasakcomposemockup.ui.theme.SecurityAppBlue
import com.tunombre.securitykasakcomposemockup.ui.theme.TextOnBlue

/*
// O define los colores aquí si NO tienes Color.kt
val SecurityAppBlue = Color(0xFF265A8A)
val LightBackground = Color(0xFFF0F4F8)
val TextOnBlue = Color.White
*/

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
    // Cambiamos los nombres de las variables de estado para evitar confusión
    // Asumimos que el 'username' para el login será el 'email' con el que se registró.
    var emailInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }
    val context = LocalContext.current // Para mostrar Toasts

    Surface(modifier = Modifier.fillMaxSize(), color = LightBackground) { // Usando tu color de fondo
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Filled.Lock,
                contentDescription = "Login Icon",
                tint = SecurityAppBlue, // Aplicando tu color
                modifier = Modifier.size(64.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Security Kasak",
                fontSize = 28.sp,
                style = MaterialTheme.typography.headlineMedium,
                color = SecurityAppBlue, // Aplicando tu color
                modifier = Modifier.padding(bottom = 32.dp)
            )

            OutlinedTextField(
                value = emailInput, // Usamos emailInput
                onValueChange = { emailInput = it.trim() }, // .trim() para quitar espacios
                label = { Text("Correo electrónico (registrado)") }, // Etiqueta actualizada
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
                // SIN personalización de 'colors' para mantenerlo simple
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = passwordInput, // Usamos passwordInput
                onValueChange = { passwordInput = it },
                label = { Text("Contraseña") },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
                // SIN personalización de 'colors' para mantenerlo simple
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    // Lógica de inicio de sesión simulada con UserManager
                    if (UserManager.isUserRegistered(emailInput, passwordInput)) {
                        // Si el usuario está "registrado", navegamos al dashboard
                        navController.navigate("dashboard") {
                            // Limpiar la pila hasta la pantalla de bienvenida para que el login
                            // no aparezca al presionar "atrás" desde el dashboard.
                            popUpTo("welcome") { inclusive = true }
                        }
                    } else {
                        // Si no, mostramos un mensaje de error
                        Toast.makeText(context, "Correo o contraseña incorrectos, o no estás registrado.", Toast.LENGTH_LONG).show()
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = SecurityAppBlue) // Aplicando tu color al botón
            ) {
                Text("Ingresar", color = TextOnBlue) // Aplicando tu color al texto del botón
            }
            Spacer(modifier = Modifier.height(16.dp))
            TextButton(onClick = {
                // Navegar a la pantalla de registro si el usuario no tiene cuenta
                navController.navigate("register")
            }) {
                Text("No tengo cuenta, registrarme", color = SecurityAppBlue) // Aplicando tu color
            }
        }
    }
}