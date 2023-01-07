package com.example.recyclerviewdasar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewdasar.databinding.ItemRowHeroBinding

class ListHeroAdapter (private val listHero : ArrayList<Hero>) : RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {


//    buat re-recycle item untuk menentukan bagaimana data ditampilkan ke dalam layout item
//    atau bahasa simpel nya buat item view untuk si recyclerView
    class ListViewHolder (var binding: ItemRowHeroBinding) : RecyclerView.ViewHolder(binding.root) {
    }

//  menghubungkan adapter dengan layout item    
    override fun onCreateViewHolder(viewGroup: ViewGroup, i : Int): ListViewHolder {
        val binding = ItemRowHeroBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

//    Tetapkan data source ke dalam viewHolder dengan fungsi onBindViewHolder
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listHero[position]
        holder.binding.imgItemPhoto.setImageResource(photo)
        holder.binding.tvItemName.text = name
        holder.binding.tvItemDescription.text = description

//        Tiga Holder diatas yang ditetapkan data nya, dibawah nya lain lagi

        holder.itemView.setOnClickListener{
            Toast.makeText(holder.itemView.context, "Kamu Memilih Pahlawan: " + listHero[holder.adapterPosition].name, Toast.LENGTH_LONG)
                .show()
        }
    }

//    Kasih ukuran list data di viewHolder
    override fun getItemCount(): Int {
        return listHero.size
    }

}

/**
 * ViewHolder adalah wrapper seperti View yang berisi layout untuk setiap item dalam daftar RecyclerView.
 * bahasa simpel nya viewHolder tempat menampung semua item yang ada
 */