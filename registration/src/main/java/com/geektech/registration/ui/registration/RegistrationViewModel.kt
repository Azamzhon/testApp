package com.geektech.registration.ui.registration

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.geektech.core.BaseViewModel
import kg.bishkek.ruslan.data.models.RepositoryApi
import kg.bishkek.ruslan.data.models.Status
import kg.bishkek.ruslan.data.models.list_available_country.Country
import kg.bishkek.ruslan.data.models.list_gender.Gender
import kg.bishkek.ruslan.data.models.list_nationality.National
import kg.bishkek.ruslan.data.models.list_secret_question.Question
import kg.bishkek.ruslan.data.models.list_traffic_source.Traffic
import kg.bishkek.ruslan.data.utils.LOGCAT_TEG
import java.util.*

class RegistrationViewModel(val api: RepositoryApi) : BaseViewModel() {

    val listGender = MutableLiveData<MutableList<Gender>>()
    val listNationals = MutableLiveData<MutableList<National>>()
    val listAvailableCountry = MutableLiveData<MutableList<Country>>()
    val listTrafficSource = MutableLiveData<MutableList<Traffic>>()
    val listSecretQuestion = MutableLiveData<MutableList<Question>>()

    init {
        api.getListGender().observeForever { resource ->
            if (resource.status == Status.SUCCESS)
                resource.data?.result?.let { listGender.value = it.toMutableList() }
        }

        api.getListNationality().observeForever { resource ->
            if (resource.status == Status.SUCCESS)
                resource.data?.result?.let { listNationals.value = it.toMutableList() }
        }

        api.getListAvailableCountry().observeForever { resource ->
            if (resource.status == Status.SUCCESS)
                resource.data?.result?.let { listAvailableCountry.value = it.toMutableList() }
        }

        api.getListTrafficSource().observeForever { resource ->
            if (resource.status == Status.SUCCESS)
                resource.data?.result?.let { listTrafficSource.value = it.toMutableList() }
        }

        api.getListSecretQuestions().observeForever { resource ->
            if (resource.status == Status.SUCCESS)
                resource.data?.result?.let { listSecretQuestion.value = it.toMutableList() }
        }
    }

    fun register(
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
    ) {
        api.registrations(
            lastName,
            firstName,
            secondName,
            uDate,
            gender,
            nationality,
            firstPhone,
            secondPhone,
            question,
            response,
            trafficSource,
            smsCode
        ).observeForever {
            if (it.status == Status.SUCCESS) {
                Log.e(LOGCAT_TEG, "register: OMG IT'S WORKED")
            } else if(it.status == Status.ERROR) {
                Log.e(LOGCAT_TEG, "register: я не удивлен.... ex: \n${it.message}")
            }
        }
    }
}