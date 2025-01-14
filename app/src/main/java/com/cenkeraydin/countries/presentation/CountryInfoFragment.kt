package com.cenkeraydin.countries.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.cenkeraydin.countries.databinding.FragmentCountryInfoBinding


class CountryInfoFragment : Fragment() {

    private lateinit var binding: FragmentCountryInfoBinding
    private lateinit var viewModel: CountryInfoViewModel

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

        viewModel = ViewModelProvider(this)[CountryInfoViewModel::class.java]
        viewModel.getDataFromRoom()
        observeLiveData()
        arguments?.let {
            countryUuid = CountryInfoFragmentArgs.fromBundle(it).countryUuid
        }
    }
    private fun observeLiveData(){
        viewModel.country.observe(viewLifecycleOwner){countries ->
            countries?.let {
                binding.countryNameTv.text = countries.country_name
                binding.countryCapitalTv.text = countries.country_capital
                binding.countryCurrencyTv.text = countries.country_currency
                binding.countryLanguageTv.text = countries.country_language
                binding.countryRegionTv.text = countries.country_region
            }
        }
    }
}