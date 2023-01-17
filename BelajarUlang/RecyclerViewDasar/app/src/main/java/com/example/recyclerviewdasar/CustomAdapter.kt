package com.example.recyclerviewdasar

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewdasar.databinding.ItemlayoutBinding

class CustomAdapter(private var listKota: ArrayList<Kota>) : RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {

    class MyViewHolder (var binding: ItemlayoutBinding) : RecyclerView.ViewHolder(binding.root){
    }

//    Membuat widget untuk item
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, i : Int): MyViewHolder {
        val itemViewList = ItemlayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemViewList)
    }

//    Set kan data tersebut ke daftar item recycleView
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val (name, image) = listKota[position]
        holder.binding.tvNamaKota.text = name
        holder.binding.imgImageCity.setImageResource(image)

        val movetoDetail = Intent(holder.itemView.context, DetailInfo::class.java)
        holder.binding.btMoveActivity.setOnClickListener {

            movetoDetail.putExtra(DetailInfo.EXTRA_NAME, listKota[position].name)
            movetoDetail.putExtra(DetailInfo.EXTRA_IMAGE, listKota[position].image)
            movetoDetail.putExtra(DetailInfo.EXTRA_DESC, listKota[position].description)
            holder.itemView.context.startActivity(movetoDetail)
        }
    }

//    ambil jumlah data tersebut
    override fun getItemCount(): Int {
        return listKota.size
    }
}