package kg.bishkek.ruslan.data.models

import androidx.lifecycle.LiveData
import kg.bishkek.ruslan.data.models.auth.LoginResult
import kg.bishkek.ruslan.data.models.check_code.CheckCodeResult
import kg.bishkek.ruslan.data.models.list_available_country.ListAvailableCountryResult
import kg.bishkek.ruslan.data.models.list_gender.ListGenderResult
import kg.bishkek.ruslan.data.models.list_nationality.ListNationalityResult
import kg.bishkek.ruslan.data.models.list_secret_question.ListSecretQuestionResult
import kg.bishkek.ruslan.data.models.list_traffic_source.ListTrafficSourceResult
import kg.bishkek.ruslan.data.models.phone_check.PhoneCheckResult
import kg.bishkek.ruslan.data.models.regisration.RegistrationResult
import java.util.*

/**
 * RepositoryApi it's a RepositoryImpl control for contact the api service
 */
interface RepositoryApi {
    fun checkPhone(phone: String): LiveData<Resource<PhoneCheckResult>>
    fun checkCode(code: Int): LiveData<Resource<CheckCodeResult>>
    fun getListGender(): LiveData<Resource<ListGenderResult>>
    fun getListSecretQuestions(): LiveData<Resource<ListSecretQuestionResult>>
    fun getListTrafficSource(): LiveData<Resource<ListTrafficSourceResult>>
    fun getListAvailableCountry(): LiveData<Resource<ListAvailableCountryResult>>
    fun getListNationality(): LiveData<Resource<ListNationalityResult>>

    fun login(
        login: String,
        password: String,
        uid: String,
        appid: String
    ): LiveData<Resource<LoginResult>>

    fun registrations(
        lastName: String,
        firstName: String,
        secondName: String,
        uDate: Date,
        gender: Int,
        nationality: Int,
        firstPhone: String,
        secondPhone: String,
        question: Int,
        response: String,
        trafficSource: Int,
        smsCode: String
    ): LiveData<Resource<RegistrationResult>>
}