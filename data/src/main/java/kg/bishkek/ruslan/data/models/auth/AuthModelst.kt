package kg.bishkek.ruslan.data.models.auth


data class LoginModel(
    val appid: String? = null,
    val login: String? = null,
    val password: String? = null,
    val uid: String? = null,
    val system: Int = 2
)

data class LoginResult(
    var code: Int? = null,
    var error: Error? = null,
    var result: Result? = null
)

data class Error(
    var code: Int? = null,
    var message: String? = null
)

data class Result(
    var login: String? = null,
    var token: String? = null
)
