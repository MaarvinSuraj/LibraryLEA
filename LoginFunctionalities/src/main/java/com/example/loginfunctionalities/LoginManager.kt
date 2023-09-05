package com.example.loginfunctionalities

class LoginManager {
    private val credentialsMap = mapOf(
        "user1" to "password1",
        "user2" to "password2",
        "user3" to "password3",
        "user4" to "password4",
        "user5" to "password5"
    )

    fun login(username: String, password: String): Boolean {
        val correctPassword = credentialsMap[username]

        return correctPassword != null && password == correctPassword
    }
}
