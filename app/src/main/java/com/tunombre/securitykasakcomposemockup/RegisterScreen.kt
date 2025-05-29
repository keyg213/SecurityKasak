package com.tunombre.securitykasakcomposemockup // Reemplaza con tu nombre de paquete real

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PersonAdd // Para el ícono de registro
import androidx.compose.material3.* // Importación general de Material 3
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
// import androidx.compose.ui.graphics.Color // No la necesitamos si no personalizamos colores aquí
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

// --- Tus Colores (Asegúrate de que este paquete sea correcto si usas Color.kt) ---
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
fun RegisterScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    val context = LocalContext.current

    Surface(modifier = Modifier.fillMaxSize(), color = LightBackground) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Filled.PersonAdd,
                contentDescription = "Register Icon",
                tint = SecurityAppBlue, // Usando tu color personalizado
                modifier = Modifier.size(64.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Crear Cuenta",
                fontSize = 28.sp,
                style = MaterialTheme.typography.headlineMedium,
                color = SecurityAppBlue, // Usando tu color personalizado
                modifier = Modifier.padding(bottom = 32.dp)
            )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it.trim() }, // Añadido .trim() para quitar espacios
                label = { Text("Correo electrónico") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
                // SIN la línea "colors = TextFieldDefaults.outlinedTextFieldColors(...)"
            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Contraseña") },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
                // SIN la línea "colors = TextFieldDefaults.outlinedTextFieldColors(...)"
            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = { Text("Confirmar contraseña") },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
                // SIN la línea "colors = TextFieldDefaults.outlinedTextFieldColors(...)"
            )
            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    // Validación básica
                    if (email.isBlank() || password.isBlank()) {
                        Toast.makeText(context, "Correo y contraseña no pueden estar vacíos.", Toast.LENGTH_SHORT).show()
                    } else if (password.length < 6) { // Ejemplo: contraseña mínima de 6 caracteres
                        Toast.makeText(context, "La contraseña debe tener al menos 6 caracteres.", Toast.LENGTH_SHORT).show()
                    } else if (password != confirmPassword) {
                        Toast.makeText(context, "Las contraseñas no coinciden.", Toast.LENGTH_SHORT).show()
                    } else {
                        // "Guardamos" el usuario usando UserManager
                        UserManager.registerUser(email, password)
                        Toast.makeText(context, "¡Registro exitoso! Ahora puedes iniciar sesión.", Toast.LENGTH_LONG).show()
                        // Navega a la pantalla de login
                        navController.navigate("login") {
                            // Limpia la pila hasta la pantalla de bienvenida para que no vuelvas al registro
                            // y si el usuario presiona atrás desde login, va a welcome.
                            popUpTo("welcome") { inclusive = false }
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = SecurityAppBlue) // Usando tu color personalizado
            ) {
                Text("Registrarse", color = TextOnBlue) // Usando tu color personalizado
            }
            Spacer(modifier = Modifier.height(16.dp))
            TextButton(onClick = { navController.popBackStack() }) { // Para volver a la pantalla anterior (Bienvenida)
                Text("Ya tengo cuenta", color = SecurityAppBlue) // Usando tu color personalizado
            }
        }
    }
}