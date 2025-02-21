package com.example.crudprofile.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.crudprofile.R
import androidx.lifecycle.lifecycleScope
import com.example.crudprofile.model.PeopleModel
import com.example.crudprofile.screen.EditProfile
import com.example.crudprofile.service.ProfileNetwork
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListAdapter(context: Context, private var peopleList: MutableList<PeopleModel>) :
    ArrayAdapter<PeopleModel>(context, R.layout.card_people, peopleList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val profile: ProfileNetwork = ProfileNetwork()
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.card_people, parent, false)

        val listData = getItem(position)
        val listImage = view.findViewById<ImageView>(R.id.imagePeople)
        val tittle = view.findViewById<TextView>(R.id.tittleCard)
        val subtittle = view.findViewById<TextView>(R.id.subtittleCard)
        val iconDetail = view.findViewById<ImageView>(R.id.bupdateprofile)
        val iconDelete = view.findViewById<ImageView>(R.id.budeleteprofile)

        listData?.let {
            Glide.with(context).load(it.avatar)
                .placeholder(R.drawable.placeholder_card)
                .error(R.drawable.imageerror)
                .into(listImage)

            tittle.text = it.name
            subtittle.text = it.address

        }

        iconDetail.setOnClickListener {

            val navPushEditProfile = Intent(context, EditProfile::class.java )
            navPushEditProfile.putExtra("extraEditProfile", peopleList[position])
            navPushEditProfile.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(navPushEditProfile)
        }

        iconDelete.setOnClickListener {
            Log.i("Click Item", "Click Item Delete Index: $position and Profile Index ${peopleList[position].id}" )
            try {
                CoroutineScope(Dispatchers.IO).launch {
                    profile.deleteProfile(peopleList[position].id)
                    withContext(Dispatchers.Main){
                        peopleList.removeIf {
                            it.id == peopleList[position].id
                        }
                        notifyDataSetChanged()

                    }
                }
            }catch (e : Exception) {
                Log.e("Error Delete Profile", e.message ?: "Not found Message Error")
            }

        }

        return view
    }
}
