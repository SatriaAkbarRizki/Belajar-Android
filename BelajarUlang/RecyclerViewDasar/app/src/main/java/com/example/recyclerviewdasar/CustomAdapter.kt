package com.example.recyclerviewdasar

import android.icu.text.Transliterator.Position
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewdasar.databinding.ActivityMainBinding
import com.example.recyclerviewdasar.databinding.ItemlayoutBinding

class CustomAdapter (private var namaKota : ArrayList<String>) : RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {

    class MyViewHolder (var binding: ItemlayoutBinding) : RecyclerView.ViewHolder(binding.root){
    }
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, i : Int): MyViewHolder {
        val itemViewList = ItemlayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemViewList)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = namaKota[position]
        holder.binding.tvItemView.text = item
    }

    override fun getItemCount(): Int {
        return namaKota.size
    }
}