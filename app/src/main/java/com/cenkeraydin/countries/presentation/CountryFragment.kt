package com.cenkeraydin.countries.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cenkeraydin.countries.R
import com.cenkeraydin.countries.adapter.CountryAdapter
import com.cenkeraydin.countries.databinding.FragmentCountryBinding


class CountryFragment : Fragment() {

    private lateinit var binding: FragmentCountryBinding
    private lateinit var viewModel : CountryViewModel
    private val countryAdapter = CountryAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =DataBindingUtil.inflate(inflater, R.layout.fragment_country, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[CountryViewModel::class.java]
        viewModel.refreshData()
        binding.countryRv.layoutManager = LinearLayoutManager(context)
        binding.countryRv.adapter = countryAdapter

        binding.swipeRefreshLayout.setOnRefreshListener {
            binding.countryRv.visibility = View.GONE
            binding.errorTv.visibility = View.GONE
            binding.loadingPb.visibility = View.VISIBLE
            viewModel.refreshData()
            binding.swipeRefreshLayout.isRefreshing = false
        }

        observeLiveData()
    }

    private fun observeLiveData(){
        viewModel.countries.observe(viewLifecycleOwner) { countries ->
            countries?.let {
                binding.countryRv.visibility = View.VISIBLE
                countryAdapter.updateCountryList(countries)
            }
        }

        viewModel.countryError.observe(viewLifecycleOwner) { error ->
            error?.let {
                if(it){
                    binding.errorTv.visibility = View.VISIBLE
                }else{
                    binding.errorTv.visibility = View.GONE
                }
            }
        }

        viewModel.countryLoading.observe(viewLifecycleOwner) { loading ->
            loading?.let {
                if(it){
                    binding.loadingPb.visibility = View.VISIBLE
                    binding.countryRv.visibility = View.GONE
                    binding.errorTv.visibility = View.GONE
                }else{
                    binding.loadingPb.visibility = View.GONE
                }
            }
        }
    }

}