package com.example.makanannusantara

import android.content.Context
import android.content.Intent
import android.icu.text.Transliterator.Position
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.makanannusantara.ActivityOther.DescriptionFood
import com.example.makanannusantara.Data.ClickToActivity
import com.example.makanannusantara.Data.DataFood
import com.example.makanannusantara.databinding.ActivityListItemFoodBinding

class CustomAdapter(val listFood: ArrayList<DataFood>, val clickToActivity: ClickToActivity)
    :  RecyclerView.Adapter<CustomAdapter.CustomHolder>() {



    class CustomHolder(var binding: ActivityListItemFoodBinding , private val context: Context) : RecyclerView.ViewHolder(binding.root){
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {
        val listRecycler =
            ActivityListItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomHolder(listRecycler, parent.context)
    }

    override fun onBindViewHolder(holder: CustomHolder,position: Int) {
        val (name, image) = listFood[position]
        holder.binding.tvFood.text = name
        holder.binding.imgFood.setImageResource(image)

        val getData = Intent(holder.itemView.context, DescriptionFood::class.java)
        holder.itemView.setOnClickListener {
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
