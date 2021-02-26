package kg.bishkek.ruslan.data.models.list_available_country

data class ListAvailableCountryModel(val id: Int)

data class ListAvailableCountryResult(
    var code: Int? = null,
    var error: Error? = null,
    var result: List<Country>? = null
)

data class Error(
    var code: Int? = null,
    var message: String? = null
)

data class Country(
    var id: String? = null,
    var iso_code: String? = null,
    var name: String? = null,
    var phone_code: String? = null,
    var phone_length: String? = null,
    var phone_mask: String? = null,
    var phone_mask_small: String? = null
)