package com.geektech.registration.ui.already_registered

import com.geektech.core.BaseFragment
import com.geektech.registration.R
import com.geektech.registration.databinding.FragmentAlreadyRegisteredBinding
import org.koin.java.KoinJavaComponent.inject

class AlreadyRegisteredFragment: BaseFragment<AlreadyRegisteredViewModel, FragmentAlreadyRegisteredBinding>(R.layout.fragment_already_registered){
    override fun getViewModel(): AlreadyRegisteredViewModel = inject(AlreadyRegisteredViewModel::class.java).value

    override fun getViewBinding(): FragmentAlreadyRegisteredBinding? = rootView?.let {
        FragmentAlreadyRegisteredBinding.bind(
            it
        )
    }

}