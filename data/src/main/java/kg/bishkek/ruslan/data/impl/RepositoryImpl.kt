package kg.bishkek.ruslan.data.impl

import android.util.Log
import androidx.lifecycle.liveData
import kg.bishkek.ruslan.data.models.RepositoryApi
import kg.bishkek.ruslan.data.models.Resource
import kg.bishkek.ruslan.data.models.auth.LoginModel
import kg.bishkek.ruslan.data.models.check_code.CheckCodeModel
import kg.bishkek.ruslan.data.models.list_available_country.ListAvailableCountryModel
import kg.bishkek.ruslan.data.models.list_gender.ListGenderModel
import kg.bishkek.ruslan.data.models.list_nationality.ListNationalityModel
import kg.bishkek.ruslan.data.models.list_secret_question.ListSecretQuestionModel
import kg.bishkek.ruslan.data.models.list_traffic_source.ListTrafficSourceModel
import kg.bishkek.ruslan.data.models.phone_check.PhoneCheckModel
import kg.bishkek.ruslan.data.models.regisration.RegistrationModel
import kg.bishkek.ruslan.data.network.apies.RequestApi
import kg.bishkek.ruslan.data.preferences.IdPreferences
import kg.bishkek.ruslan.data.utils.LOGCAT_TEG
import kg.bishkek.ruslan.data.utils.StatusCode
import kotlinx.coroutines.Dispatchers
import java.util.*

/**
 * RepositoryImpl is class implementing RepositoryApi
 * this class for implementation your REST questions
 */
class RepositoryImpl(
    private val api: RequestApi,
    private val idPreferences: IdPreferences
) : RepositoryApi {

    override fun checkPhone(phone: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))

        try {
            val body = PhoneCheckModel(phone)
            val result = api.checkPhone(body)

            if (result.code == StatusCode.Success.code) {
                if (result.error != null) {
                    emit(Resource.error(null, "number is busy"))
                } else if (result.result != null) {
                    result.result?.id?.let { idPreferences.id = it }
                    emit(Resource.success(result))
                }
            }

        } catch (e: Exception) {
            emit(Resource.error(null, e.message.toString()))
        }
    }

    override fun checkCode(code: Int) = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))

        try {
            val body = CheckCodeModel(idPreferences.id, code)
            val result = api.checkCode(body)

            if (result.code == StatusCode.Success.code) {
                if (result.error != null && result.error?.code == StatusCode.BadRequest.code) {
                    emit(Resource.error(null, result.error?.message.toString()))
                } else if (result.result != null && result.result?.code == StatusCode.Success.code) {
                    emit(Resource.success(result))
                }
            }
        } catch (e: Exception) {
            emit(Resource.error(null, e.message.toString()))
        }
    }

    override fun getListGender() = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))

        try {
            val body = ListGenderModel(idPreferences.id)
            val result = api.getListGender(body)

            if (result.code == StatusCode.Success.code) {
                if (result.result != null)
                    emit(Resource.success(result))
                else if (result.error != null) {
                    emit(Resource.error(null, result.error?.message.toString()))
                }
            }

        } catch (e: Exception) {
            Resource.error(null, e.message.toString())
        }
    }

    override fun getListSecretQuestions() = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))

        try {
            val body = ListSecretQuestionModel(idPreferences.id)
            val result = api.getListSecretQuestions(body)

            if (result.code == StatusCode.Success.code) {
                if (result.result != null)
                    emit(Resource.success(result))
                else if (result.error != null) {
                    emit(Resource.error(null, result.error?.message.toString()))
                }
            }

        } catch (e: Exception) {
            Resource.error(null, e.message.toString())
        }
    }

    override fun getListTrafficSource() = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))

        try {
            val body = ListTrafficSourceModel(idPreferences.id)
            val result = api.getListTrafficSource(body)

            if (result.code == StatusCode.Success.code) {
                if (result.result != null)
                    emit(Resource.success(result))
                else if (result.error != null) {
                    emit(Resource.error(null, result.error?.message.toString()))
                }
            }

        } catch (e: Exception) {
            Resource.error(null, e.message.toString())
        }
    }

    override fun getListAvailableCountry() = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))

        try {
            val body = ListAvailableCountryModel(idPreferences.id)
            val result = api.getListAvailableCountry(body)

            if (result.code == StatusCode.Success.code) {
                if (result.result != null)
                    emit(Resource.success(result))
                else if (result.error != null) {
                    emit(Resource.error(null, result.error?.message.toString()))
                }
            }

        } catch (e: Exception) {
            Resource.error(null, e.message.toString())
        }
    }

    override fun getListNationality() = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))

        try {
            val body = ListNationalityModel(idPreferences.id)
            val result = api.getListNationality(body)

            if (result.code == StatusCode.Success.code) {
                if (result.result != null)
                    emit(Resource.success(result))
                else if (result.error != null) {
                    emit(Resource.error(null, result.error?.message.toString()))
                }
            }

        } catch (e: Exception) {
            Resource.error(null, e.message.toString())
        }
    }

    override fun login(login: String, password: String, uid: String, appid: String) =
        liveData(Dispatchers.IO) {
            emit(Resource.loading(null))

            try {
                val body = LoginModel(appid, login, password, uid)
                val result = api.login(body)

                if (result.code == StatusCode.Success.code) {
                    if (result.result != null)
                        emit(Resource.success(result))
                    else if (result.error != null) {
                        emit(Resource.error(null, result.error?.message.toString()))
                    }
                }

            } catch (e: Exception) {
                Resource.error(null, e.message.toString())
            }
        }

    override fun registrations(
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
    ) = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))

        try {
            val body = RegistrationModel(
                firstName,
                firstPhone,
                gender,
                lastName,
                nationality,
                question,
                response,
                secondName,
                secondPhone,
                smsCode,
                trafficSource,
                uDate
            )
            val result = api.registrations(body)

            if (result.code == StatusCode.Success.code) {
                if (result.result != null)
                    emit(Resource.success(result))
                else if (result.error != null) {
                    emit(Resource.error(null, result.error?.message.toString()))
                }
            }

        } catch (e: Exception) {
            Resource.error(null, e.message.toString())
        }
    }

}