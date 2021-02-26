package kg.bishkek.ruslan.data.models.phone_check

data class PhoneCheckModel(
    val phone: String
)

data class PhoneCheckResult(
    var code: Int? = null,
    var result: Result? = null,
    var error: Error? = null
)

data class Result(
    var id: Int? = null
)

data class Error(
    var code: Int? = null,
    var message: String? = null
)