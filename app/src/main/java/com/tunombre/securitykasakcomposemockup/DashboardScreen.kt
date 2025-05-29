package com.tunombre.securitykasakcomposemockup // Reemplaza con tu nombre de paquete real

// ... otras importaciones ...
import androidx.compose.foundation.clickable // <<--- AÑADE O VERIFICA ESTA LÍNEA
import androidx.compose.foundation.layout.*
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
// No necesitamos importaciones de androidx.compose.material.icons.* por ahora
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card // Seguiremos usando Card para un mejor aspecto
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

// --- Tus Colores (Asegúrate de que este paquete sea correcto si usas Color.kt) ---
import com.tunombre.securitykasakcomposemockup.ui.theme.LightBackground
import com.tunombre.securitykasakcomposemockup.ui.theme.SecurityAppBlue
import com.tunombre.securitykasakcomposemockup.ui.theme.TextOnLight
// import com.tunombre.securitykasakcomposemockup.ui.theme.SecurityAppAccentGold

/*
// O define los colores aquí si NO tienes Color.kt
val SecurityAppBlue = Color(0xFF265A8A)
val LightBackground = Color(0xFFF0F4F8)
val TextOnLight = Color.Black
*/

// Data class simplificada, ya no incluye 'icon'
data class FeatureItemSimple(
    val name: String,
    val descriptionToast: String
)

@Composable
fun DashboardScreen(navController: NavController) {
    val context = LocalContext.current

    // Lista de funciones con sus descripciones específicas, sin íconos
    val features = listOf(
        FeatureItemSimple(
            "Protección de Datos (Bóveda)",
            "Aquí guardarás y cifrarás tus archivos y notas más importantes de forma segura."
        ),
        FeatureItemSimple(
            "Gestión de Contraseñas",
            "Este será tu gestor para crear, guardar y usar contraseñas fuertes y únicas para todas tus cuentas."
        ),
        FeatureItemSimple(
            "Autenticación Multifactor (2FA)",
            "Gestiona tus códigos de autenticación de dos factores para añadir una capa extra de seguridad a tus inicios de sesión."
        ),
        FeatureItemSimple(
            "Navegación Segura",
            "Activa el navegador seguro para protegerte contra rastreadores, phishing y sitios web maliciosos mientras navegas."
        ),
        FeatureItemSimple(
            "Análisis del Dispositivo",
            "Escanea tu dispositivo en busca de configuraciones inseguras, permisos riesgosos en apps y posibles amenazas."
        ),
        FeatureItemSimple(
            "Privacidad de Datos del Usuario",
            "Controla y configura opciones avanzadas para maximizar tu privacidad en línea y la protección de tus datos personales."
        ),
        FeatureItemSimple(
            "Protección Ataques Cibernéticos",
            "Accede a herramientas y alertas para defenderte activamente contra diferentes tipos de ataques cibernéticos."
        )
    )

    Surface(modifier = Modifier.fillMaxSize(), color = LightBackground) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Panel de Funciones KASAK",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = SecurityAppBlue,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            features.forEach { feature ->
                DashboardFeatureItemSimple( // Usamos la nueva función Composable simplificada
                    featureName = feature.name,
                    onClick = {
                        Toast.makeText(context, feature.descriptionToast, Toast.LENGTH_LONG).show()
                    }
                )
            }

            Spacer(modifier = Modifier.weight(1f)) // Empuja el botón hacia abajo

            Button(
                onClick = {
                    navController.navigate("login") {
                        popUpTo("dashboard") { inclusive = true }
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
            ) {
                Text("Cerrar Sesión (Simulado)")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class) // Para Card
@Composable
fun DashboardFeatureItemSimple(featureName: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 7.dp)
            .clickable { onClick() }, // Mantenemos la Card clickeable
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row( // Usamos Row para alinear el texto
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 20.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically // Centra el texto verticalmente
        ) {
            // No hay Icon aquí
            Text(
                text = featureName,
                style = MaterialTheme.typography.titleMedium,
                color = TextOnLight, // Color del texto
                fontSize = 17.sp,
                modifier = Modifier.weight(1f) // Permite que el texto ocupe el espacio disponible
            )
        }
    }
}