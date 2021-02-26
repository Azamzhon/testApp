package com.geektech.registration.ui.service_locator

import com.geektech.registration.ui.enter_code.EnterCodeViewModel
import com.geektech.registration.ui.enter_phone.EnterPhoneViewModel
import com.geektech.registration.ui.main.MainViewModel
import com.geektech.registration.ui.registration.RegistrationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val registrationModule = module {
    viewModel { EnterCodeViewModel(get()) }
    viewModel { EnterPhoneViewModel(get()) }
    viewModel { RegistrationViewModel(get()) }
    viewModel { MainViewModel() }
}