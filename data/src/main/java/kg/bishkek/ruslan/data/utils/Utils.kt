package kg.bishkek.ruslan.data.utils

//rest query const and endPoints
const val BASE_URL = "https://test.dengi-credit.org/api/app/"
const val LOGIN = "login"
const val CHECK_PHONE = "checkPhone"
const val CHECK_CODE = "checkCode"
const val GET_LIST_GENDER = "listGender"
const val GET_LIST_NATIONALITY = "listNationality"
const val GET_LIST_AVAILABLE_COUNTRY = "listAvailableCountry"
const val GET_LIST_TRAFFIC_SOURCE = "listTrafficSource"
const val GET_LIST_SECRET_QUESTIONS = "listSecretQuestion"
const val REGISTRATION = "registration"

//other const
const val SHARED_PREFERENCES_NAME = "shared_preferences_name"
const val LOGCAT_TEG = "logcat_teg_ololo"
const val SYSTEM_CODE = 1

//api result const
enum class StatusCode(val code: Int) {
    Success(200),               // Успех
    BadRequest(400),            // Неверный запрос, неверно заданы параметры (например: логин и пароль)
    UnauthorizedUser(401),      // Неавторизованный пользователь
    InvalidToken(403),          // Доступ запрещен или неверный токен
    NotFound(404),              // Метод или данные не найдены
    Duplicate(409),             // Конфликт, дубликат
    RequestLimitExceeded(429),  // Превышен лимит запросов
    ServerError(500)            // Внутренняя ошибка сервера
}