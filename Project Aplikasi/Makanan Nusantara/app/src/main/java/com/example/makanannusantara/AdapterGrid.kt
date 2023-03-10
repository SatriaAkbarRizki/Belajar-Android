package com.example.makanannusantara

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.makanannusantara.Data.ClickToActivity
import com.example.makanannusantara.Data.DataFood
import com.example.makanannusantara.databinding.ActivityGridLayoutBinding

class AdapterGrid(val listFood: ArrayList<DataFood>, val clickToActivity: ClickToActivity)
    :  RecyclerView.Adapter<AdapterGrid.CustomHolder>() {



    class CustomHolder(var binding: ActivityGridLayoutBinding, private val context: Context) : RecyclerView.ViewHolder(binding.root){
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {
        val listRecycler =
            ActivityGridLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomHolder(listRecycler, parent.context)
    }


    override fun onBindViewHolder(holder: CustomHolder,position: Int) {
        val (name, image) = listFood[position]
        holder.binding.gridTvFood.text = name
        holder.binding.gridImgFood.setImageResource(image)

        holder.binding.root.setOnClickListener {
            if (clickToActivity != null)
            {
                val pos = position
                if(pos != RecyclerView.NO_POSITION) {
                    clickToActivity.onClickItemActivity(position)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return listFood.size
    }

}