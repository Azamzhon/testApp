package kg.bishkek.ruslan.data.models.list_gender

data class ListGenderModel(
    val id: Int
)

data class ListGenderResult(
    var code: Int? = null,
    var error: Error? = null,
    var result: List<Gender>? = null
)

data class Error(
    var code: Int? = null,
    var message: String? = null
)

data class Gender(
    var id: String? = null,
    var name: String? = null
)