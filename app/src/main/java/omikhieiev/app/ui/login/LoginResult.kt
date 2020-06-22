package omikhieiev.app.ui.login

/**
 * Authentication result : success (user details) or error message.
 */
sealed class LoginResult

object Success: LoginResult()
class Error(val message: String): LoginResult()
