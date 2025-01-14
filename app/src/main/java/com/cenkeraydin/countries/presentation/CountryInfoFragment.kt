package com.cenkeraydin.countries.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cenkeraydin.countries.databinding.FragmentCountryInfoBinding


class CountryInfoFragment : Fragment() {

    private lateinit var binding: FragmentCountryInfoBinding
    private var countryUuid = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCountryInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            countryUuid = CountryInfoFragmentArgs.fromBundle(it).countryUuid
        }
    }
}