package com.example.makanannusantara

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.makanannusantara.databinding.FragmentItemFoodBinding

class CustomAdapter(val listFood: ArrayList<DataFood>) : RecyclerView.Adapter<CustomAdapter.CustomHolder>(){

    class CustomHolder(var binding : FragmentItemFoodBinding) : RecyclerView.ViewHolder(binding.root){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {
        val listRecycler = FragmentItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomHolder(listRecycler)
    }

    override fun onBindViewHolder(holder: CustomHolder, position: Int) {
        val (name, image) = listFood[position]
        holder.binding.imgFood.setImageResource(image)

    }

    override fun getItemCount(): Int {
        return listFood.size
    }
}