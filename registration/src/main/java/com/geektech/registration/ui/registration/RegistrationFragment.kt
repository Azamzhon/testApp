package com.geektech.registration.ui.registration

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.lifecycle.Observer
import com.geektech.core.BaseFragment
import com.geektech.registration.R
import com.geektech.registration.databinding.FragmentRegistrationBinding
import org.koin.java.KoinJavaComponent.inject
import java.text.SimpleDateFormat


class RegistrationFragment :
    BaseFragment<RegistrationViewModel, FragmentRegistrationBinding>(R.layout.fragment_registration) {

    var secretQuestion: Int? = null
    var gender: Int? = null
    var nationals: Int? = null
    var trafficSource: Int? = null
    var smsCode = "12345"
    var firstPhone = "996557071204"


    override fun getViewModel(): RegistrationViewModel =
        inject(RegistrationViewModel::class.java).value

    override fun getViewBinding(): FragmentRegistrationBinding? = rootView?.let {
        FragmentRegistrationBinding.bind(
            it
        )
    }

    override fun initArgs(arg: Bundle) {
        smsCode = arg.getString(SMS_CODE_KEY, "def")
        firstPhone = arg.getString(FIRST_PHONE_KEY, "def")
    }

    override fun setUpView() {
        binding?.run {
            spinnerListSecretQuestion.onItemSelectedListener = object : OnItemSelectedListener {
                override fun onItemSelected(
                    parentView: AdapterView<*>?,
                    selectedItemView: View,
                    position: Int,
                    id: Long
                ) {
                    secretQuestion =
                        mViewModel?.listSecretQuestion?.value?.get(position)?.id?.toInt()
                }

                override fun onNothingSelected(parentView: AdapterView<*>?) {}
            }
            spinnerListGender.onItemSelectedListener = object : OnItemSelectedListener {
                override fun onItemSelected(
                    parentView: AdapterView<*>?,
                    selectedItemView: View,
                    position: Int,
                    id: Long
                ) {
                    gender = mViewModel?.listGender?.value?.get(position)?.id?.toInt()
                }

                override fun onNothingSelected(parentView: AdapterView<*>?) {}
            }
            spinnerListNationality.onItemSelectedListener = object : OnItemSelectedListener {
                override fun onItemSelected(
                    parentView: AdapterView<*>?,
                    selectedItemView: View,
                    position: Int,
                    id: Long
                ) {
                    nationals = mViewModel?.listNationals?.value?.get(position)?.id
                }

                override fun onNothingSelected(parentView: AdapterView<*>?) {}
            }
            spinnerListTrafficSource.onItemSelectedListener = object : OnItemSelectedListener {
                override fun onItemSelected(
                    parentView: AdapterView<*>?,
                    selectedItemView: View,
                    position: Int,
                    id: Long
                ) {
                    trafficSource = mViewModel?.listTrafficSource?.value?.get(position)?.id?.toInt()
                }

                override fun onNothingSelected(parentView: AdapterView<*>?) {}
            }

            btnProceed.setOnClickListener {
                val lastName = binding?.etLastName?.text?.toString()?.trim()
                val firstName = binding?.etName?.text?.toString()?.trim()
                val secondName = binding?.etSecondName?.text?.toString()?.trim()
                val sDate = binding?.etChoiceDate?.text.toString().trim()
                val formatter = SimpleDateFormat("DD.MM.YYYY")
                val uDate = formatter.parse(sDate)
                val secondPhone = "966557071204"
                val response = binding?.etAskQuestion?.text?.toString()?.trim()

                if (lastName != null && lastName.isNotEmpty() &&
                    firstName != null && firstName.isNotEmpty() && uDate != null &&
                    secondName != null && secondName.isNotEmpty() &&
                    firstPhone != null && secondPhone.isNotEmpty() &&
                    response != null && response.isNotEmpty() &&
                    gender != null && nationals != null && secretQuestion != null && trafficSource != null &&
                    smsCode != null && smsCode.isNotEmpty()
                ) {
                    mViewModel?.register(
                        lastName,
                        firstName,
                        secondName,
                        uDate,
                        gender!!,
                        nationals!!,
                        firstPhone,
                        secondPhone,
                        secretQuestion!!,
                        response,
                        trafficSource!!,
                        smsCode
                    )
                }
            }
        }
    }

    override fun setUpViewModelObs() {
        mViewModel?.run {
            listSecretQuestion.observe(requireActivity(), Observer {
                val names = mutableListOf<String>()
                for (i in it) i.name?.let { name -> names.add(name) }
                binding?.spinnerListSecretQuestion?.let { spinner -> listToSpinner(names, spinner) }
            })
            listGender.observe(requireActivity(), Observer {
                val names = mutableListOf<String>()
                for (i in it) i.name?.let { name -> names.add(name) }
                binding?.spinnerListGender?.let { spinner -> listToSpinner(names, spinner) }
            })
            listNationals.observe(requireActivity(), Observer {
                val names = mutableListOf<String>()
                for (i in it) i.name?.let { name -> names.add(name) }
                binding?.spinnerListNationality?.let { spinner -> listToSpinner(names, spinner) }
            })
            listTrafficSource.observe(requireActivity(), Observer {
                val names = mutableListOf<String>()
                for (i in it) i.name?.let { name -> names.add(name) }
                binding?.spinnerListTrafficSource?.let { spinner -> listToSpinner(names, spinner) }
            })
        }
    }

    private fun listToSpinner(list: MutableList<String>, spinner: Spinner) {
        val spinnerArrayAdapter: ArrayAdapter<String> = ArrayAdapter(
            requireContext(), android.R.layout.simple_spinner_item,
            list
        )

        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = spinnerArrayAdapter
    }

    companion object {
        const val SMS_CODE_KEY = "SMS_CODE_KEY"
        const val FIRST_PHONE_KEY = "SMS_CODE_KEY"
    }
}