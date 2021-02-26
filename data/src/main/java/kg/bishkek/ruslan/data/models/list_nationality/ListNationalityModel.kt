package kg.bishkek.ruslan.data.models.list_nationality

data class ListNationalityModel(
    val id: Int
)

data class ListNationalityResult(
    var code: Int? = null,
    var error: Error? = null,
    var result: List<National>? = null
)

data class Error(
    var code: Int,
    var message: String
)

data class National(
    var id: Int? = null,
    var name: String? = null
)