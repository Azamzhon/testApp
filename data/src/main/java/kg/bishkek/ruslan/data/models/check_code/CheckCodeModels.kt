package kg.bishkek.ruslan.data.models.check_code

data class CheckCodeModel(
    val phone: Int? = null,
    val code: Int? = null
)

data class CheckCodeResult(
    var code: Int? = null,
    var result: Result? = null,
    var error: Result? = null
)

data class Result(
    var code: Int? = null,
    var message: String? = null
)