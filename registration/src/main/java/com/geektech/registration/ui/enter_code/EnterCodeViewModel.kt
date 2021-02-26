package com.geektech.registration.ui.enter_code

import androidx.lifecycle.MediatorLiveData
import com.geektech.core.BaseViewModel
import kg.bishkek.ruslan.data.models.RepositoryApi
import kg.bishkek.ruslan.data.models.Status

class EnterCodeViewModel(private val api: RepositoryApi) : BaseViewModel() {

    val currentError = MediatorLiveData<String>()
    var isSuccessVerifyCode: ((isSuccess: Boolean) -> Unit)? = null

    fun verifyCode(code: Int) {
        api.checkCode(code).observeForever { resource ->
            when (resource.status) {
                Status.SUCCESS -> {
                    isSuccessVerifyCode?.let {
                        it(true)
                    }
                }

                Status.ERROR -> {
                    resource.message?.let {
                        currentError.value = it
                    }
                }
            }
        }
    }

}