package kg.bishkek.ruslan.data.models.list_traffic_source

data class ListTrafficSourceModel(val id: Int)

data class ListTrafficSourceResult(
    var code: Int? = null,
    var error: Error? = null,
    var result: List<Traffic>? = null
)

data class Error(
    var code: Int? = null,
    var message: String? = null
)

data class Traffic(
    var id: String? = null,
    var name: String? = null
)