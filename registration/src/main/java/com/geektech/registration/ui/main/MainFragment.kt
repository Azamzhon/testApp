package com.geektech.registration.ui.main

import com.geektech.core.BaseFragment
import com.geektech.registration.R
import com.geektech.registration.databinding.FragmentMainBinding
import org.koin.java.KoinJavaComponent.inject

class MainFragment: BaseFragment<MainViewModel, FragmentMainBinding>(R.layout.fragment_main) {
    override fun getViewModel(): MainViewModel = inject(MainViewModel::class.java).value

    override fun getViewBinding(): FragmentMainBinding? = rootView?.let {
        FragmentMainBinding.bind(
            it
        )
    }
}