package com.example.distrolinux

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.distrolinux.databinding.ItemRowHeroBinding

class ListHeroAdapter (private val listHero : ArrayList<Hero>) : RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {

    class ListViewHolder (var binding: ItemRowHeroBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i : Int): ListViewHolder {
        val binding = ItemRowHeroBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listHero[position]
        holder.binding.imgItemPhoto.setImageResource(photo)
        holder.binding.tvItemName.text = name
        holder.binding.tvItemDescription.text = description

        val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)


        holder.itemView.setOnClickListener{
            intentDetail.putExtra(DetailActivity.EXTRA_NAME, listHero[holder.adapterPosition].name)
            intentDetail.putExtra(DetailActivity.EXTRA_IMAGE, listHero[holder.adapterPosition].photo)
            intentDetail.putExtra(DetailActivity.EXTRA_DESCRIPTION, listHero[holder.adapterPosition].description)
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    override fun getItemCount(): Int {
        return listHero.size
    }

}