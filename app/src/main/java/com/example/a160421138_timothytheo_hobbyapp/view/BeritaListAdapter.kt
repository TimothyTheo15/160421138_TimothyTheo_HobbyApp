package com.example.a160421138_timothytheo_hobbyapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.a160421138_timothytheo_hobbyapp.databinding.BeritaListItemBinding
import com.example.a160421138_timothytheo_hobbyapp.model.Berita
import com.example.a160421138_timothytheo_hobbyapp.util.loadImage
import java.util.ArrayList
import com.squareup.picasso.Picasso

class BeritaListAdapter(val beritaList: ArrayList<Berita>):RecyclerView.Adapter<BeritaListAdapter.BeritaViewHolder>() {
    class BeritaViewHolder(var binding: BeritaListItemBinding)
        :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeritaViewHolder {
        val binding = BeritaListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return BeritaViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return beritaList.size
    }

    override fun onBindViewHolder(holder: BeritaViewHolder, position: Int) {
        holder.binding.txtJudulBerita.text = beritaList[position].title
        holder.binding.txtUsernamePembuat.text = beritaList[position].username
        holder.binding.imgBerita.loadImage(beritaList[position].photo_url, holder.binding.progressBarImageBerita)
        holder.binding.txtDeskipsiBerita.text = beritaList[position].description
        holder.binding.btnBacaBerita.setOnClickListener {
            val action = HomeFragmentDirections.actionBeritaDetail(beritaList[position].id.toString().toInt())
            Navigation.findNavController(it).navigate(action)
        }
    }

    fun updateBeritaList(newBeritaList: ArrayList<Berita>) {
        beritaList.clear()
        beritaList.addAll(newBeritaList)
        notifyDataSetChanged()
    }


}
