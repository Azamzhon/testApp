package kg.bishkek.ruslan.data.network.apies

import kg.bishkek.ruslan.data.models.auth.LoginResult
import kg.bishkek.ruslan.data.models.auth.LoginModel
import kg.bishkek.ruslan.data.models.check_code.CheckCodeModel
import kg.bishkek.ruslan.data.models.check_code.CheckCodeResult
import kg.bishkek.ruslan.data.models.list_available_country.ListAvailableCountryModel
import kg.bishkek.ruslan.data.models.list_available_country.ListAvailableCountryResult
import kg.bishkek.ruslan.data.models.list_gender.ListGenderModel
import kg.bishkek.ruslan.data.models.list_gender.ListGenderResult
import kg.bishkek.ruslan.data.models.list_nationality.ListNationalityModel
import kg.bishkek.ruslan.data.models.list_nationality.ListNationalityResult
import kg.bishkek.ruslan.data.models.list_secret_question.ListSecretQuestionModel
import kg.bishkek.ruslan.data.models.list_secret_question.ListSecretQuestionResult
import kg.bishkek.ruslan.data.models.list_traffic_source.ListTrafficSourceModel
import kg.bishkek.ruslan.data.models.list_traffic_source.ListTrafficSourceResult
import kg.bishkek.ruslan.data.models.phone_check.PhoneCheckModel
import kg.bishkek.ruslan.data.models.phone_check.PhoneCheckResult
import kg.bishkek.ruslan.data.models.regisration.RegistrationModel
import kg.bishkek.ruslan.data.models.regisration.RegistrationResult
import kg.bishkek.ruslan.data.utils.*
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * AuthApi for call REST query
 */
interface RequestApi {

    @POST(LOGIN)
    suspend fun login(@Body body: LoginModel): LoginResult

    @POST(CHECK_PHONE)
    suspend fun checkPhone(@Body body: PhoneCheckModel): PhoneCheckResult

    @POST(CHECK_CODE)
    suspend fun checkCode(@Body body: CheckCodeModel): CheckCodeResult

    @POST(GET_LIST_GENDER)
    suspend fun getListGender(@Body body: ListGenderModel): ListGenderResult

    @POST(GET_LIST_NATIONALITY)
    suspend fun getListNationality(@Body body: ListNationalityModel): ListNationalityResult

    @POST(GET_LIST_AVAILABLE_COUNTRY)
    suspend fun getListAvailableCountry(@Body body: ListAvailableCountryModel): ListAvailableCountryResult

    @POST(GET_LIST_TRAFFIC_SOURCE)
    suspend fun getListTrafficSource(@Body body: ListTrafficSourceModel): ListTrafficSourceResult

    @POST(GET_LIST_SECRET_QUESTIONS)
    suspend fun getListSecretQuestions(@Body body: ListSecretQuestionModel): ListSecretQuestionResult

    @POST(REGISTRATION)
    suspend fun registrations(@Body body: RegistrationModel): RegistrationResult
}