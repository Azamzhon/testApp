package com.geektech.registration.ui.enter_phone

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.geektech.core.BaseFragment
import com.geektech.registration.R
import com.geektech.registration.databinding.FragmentEnterPhoneBinding
import com.geektech.registration.ui.registration.RegistrationFragment
import org.koin.java.KoinJavaComponent.inject

class EnterPhoneFragment :
    BaseFragment<EnterPhoneViewModel, FragmentEnterPhoneBinding>(R.layout.fragment_enter_phone) {

    override fun getViewModel(): EnterPhoneViewModel = inject(EnterPhoneViewModel::class.java).value

    override fun getViewBinding(): FragmentEnterPhoneBinding? = rootView?.let {
        FragmentEnterPhoneBinding.bind(
            it
        )
    }

    override fun setUpView() {
        binding?.run {
            btnNext.setOnClickListener {
                if (etPhone.text.toString().trim().isNotEmpty())
                    mViewModel?.checkPhone(etPhone.text.toString().trim())
            }
        }
    }

    override fun setUpViewModelObs() {
        mViewModel?.run {
            id.observe(requireActivity(), Observer {
                if (it != null) {
                    val args = Bundle()
                    args.putString(
                        RegistrationFragment.FIRST_PHONE_KEY,
                        binding?.etPhone?.text.toString().trim()
                    )

                    findNavController().navigate(
                        R.id.action_enterPhoneFragment_to_enterCodeFragment,
                        args
                    )
                }
            })

            isAlreadyRegistered.observe(requireActivity(), Observer {
                if (it) findNavController().navigate(R.id.action_enterPhoneFragment_to_alreadyRegisteredFragment)
            })
        }
    }

}