package com.example.disneyapp.UI.Main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.disneyapp.Model.DisneyData
import com.example.disneyapp.R
import com.example.disneyapp.databinding.MainRecyclerRowBinding

class MainFragmentAdapter(
    private val dataList : List<DisneyData>
) : RecyclerView.Adapter<MainFragmentAdapter.MainViewHolder>(){

    class MainViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = MainRecyclerRowBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.main_recycler_row, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        Glide.with(holder.itemView.context)
            .load(dataList.get(position).imageUrl)
            .error(R.drawable.ic_launcher_background)
            .into(holder.binding.imageView)

        holder.binding.textView.text = dataList.get(position).name
    }
}