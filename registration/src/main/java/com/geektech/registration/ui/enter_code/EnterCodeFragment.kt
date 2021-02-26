package com.geektech.registration.ui.enter_code

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.geektech.core.BaseFragment
import com.geektech.registration.R
import com.geektech.registration.databinding.FragmentEnterCodeBinding
import com.geektech.registration.ui.registration.RegistrationFragment
import org.koin.java.KoinJavaComponent.inject

class EnterCodeFragment: BaseFragment<EnterCodeViewModel, FragmentEnterCodeBinding>(R.layout.fragment_enter_code){

    private var firstPhone: String = "996557071204"

    override fun getViewModel(): EnterCodeViewModel = inject(EnterCodeViewModel::class.java).value

    override fun getViewBinding(): FragmentEnterCodeBinding? = rootView?.let {
        FragmentEnterCodeBinding.bind(
            it
        )
    }

    override fun initArgs(arg: Bundle) {
        firstPhone = arg.getString(RegistrationFragment.FIRST_PHONE_KEY, "996557071204")
    }

    override fun setUpView() {
        binding?.run {
            btnProceed.setOnClickListener {
                if (editTextCode.text.isNotEmpty()) {
                    mViewModel?.verifyCode(editTextCode.text.toString().toInt())
                }
            }
        }
    }

    override fun setUpViewModelObs() {
        mViewModel?.currentError?.observe(requireActivity(), Observer {
            binding?.editTextCode?.error = it
        })

        mViewModel?.isSuccessVerifyCode = {
            findNavController().run {
                val args = Bundle()
                args.putString(RegistrationFragment.SMS_CODE_KEY, binding?.editTextCode?.text.toString().trim())
                args.putString(RegistrationFragment.FIRST_PHONE_KEY, firstPhone)

                navigateUp()
                navigate(R.id.action_enterCodeFragment_to_registrationFragment, args)
            }
        }
    }
}