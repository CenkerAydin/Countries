package com.cenkeraydin.countries.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.cenkeraydin.countries.databinding.FragmentCountryInfoBinding
import com.cenkeraydin.countries.util.downloadFromUrl
import com.cenkeraydin.countries.util.placeHolderProgressBar


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
        arguments?.let {
            countryUuid = CountryInfoFragmentArgs.fromBundle(it).countryUuid
        }
        viewModel = ViewModelProvider(this)[CountryInfoViewModel::class.java]
        viewModel.getDataFromRoom(countryUuid)
        observeLiveData()

    }
    private fun observeLiveData(){
        viewModel.countryLiveData.observe(viewLifecycleOwner){countries ->
            countries?.let {
              binding.country =countries
            }
        }
    }
}