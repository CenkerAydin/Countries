package com.cenkeraydin.countries.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.cenkeraydin.countries.R
import com.cenkeraydin.countries.data.model.Country
import com.cenkeraydin.countries.databinding.ItemCountryBinding
import com.cenkeraydin.countries.presentation.CountryFragmentDirections
import com.cenkeraydin.countries.util.downloadFromUrl
import com.cenkeraydin.countries.util.placeHolderProgressBar

class CountryAdapter(val country_list:ArrayList<Country>): RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    class CountryViewHolder(var view: ItemCountryBinding): RecyclerView.ViewHolder(view.root){

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemCountryBinding>(inflater,R.layout.item_country,parent,false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
       holder.view.country = country_list[position]
        holder.view.root.setOnClickListener {
            val action = CountryFragmentDirections.actionCountryFragmentToCountryInfoFragment(country_list[position].uuid)
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return country_list.size
    }

    fun updateCountryList(newCountryList: List<Country>){
        country_list.clear()
        country_list.addAll(newCountryList)
        notifyDataSetChanged()
    }
}