package com.tunombre.securitykasakcomposemockup // Reemplaza con tu paquete

object UserManager {
    var registeredEmail: String? = null
    var registeredPassword: String? = null // Guardamos la contraseña solo para la simulación

    fun registerUser(email: String, password: String) {
        registeredEmail = email
        registeredPassword = password
        // En una app real, aquí guardarías esto en una base de datos cifrada o lo enviarías a un servidor.
    }

    fun isUserRegistered(email: String, password: String): Boolean {
        // En una app real, consultarías la base de datos o el servidor.
        // Para la simulación, solo verificamos si el email y la contraseña coinciden con los "registrados".
        return email.isNotEmpty() && password.isNotEmpty() && email == registeredEmail && password == registeredPassword
    }

    fun clearRegistration() {
        // Para simular "cerrar sesión" o reiniciar el estado
        registeredEmail = null
        registeredPassword = null
    }
}