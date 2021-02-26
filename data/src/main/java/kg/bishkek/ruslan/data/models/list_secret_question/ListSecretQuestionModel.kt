package kg.bishkek.ruslan.data.models.list_secret_question

data class ListSecretQuestionModel(val id: Int)

data class ListSecretQuestionResult(
    var code: Int? = null,
    var error: Error? = null,
    var result: List<Question>? = null
)

data class Error(
    var code: Int? = null,
    var message: String? = null
)

data class Question(
    var id: String? = null,
    var name: String? = null
)