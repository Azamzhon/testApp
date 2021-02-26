package com.geektech.registration.ui.enter_phone

import androidx.lifecycle.MutableLiveData
import com.geektech.core.BaseViewModel
import kg.bishkek.ruslan.data.models.RepositoryApi
import kg.bishkek.ruslan.data.models.Status
import kg.bishkek.ruslan.data.utils.StatusCode

class EnterPhoneViewModel(private val repositoryApi: RepositoryApi) : BaseViewModel() {

    val id = MutableLiveData<Int>()
    val isAlreadyRegistered = MutableLiveData<Boolean>(false)

    fun checkPhone(phone: String) {
        repositoryApi.checkPhone(phone).observeForever { resource ->
            if (resource.status == Status.SUCCESS) {
                resource.data?.result?.id?.let {
                    id.value = it
                }
            }

            if (resource.data?.code == StatusCode.Success.code && resource.data?.error != null && resource.data?.error?.code == StatusCode.Duplicate.code) {
                isAlreadyRegistered.value = true
            }
        }
    }

}