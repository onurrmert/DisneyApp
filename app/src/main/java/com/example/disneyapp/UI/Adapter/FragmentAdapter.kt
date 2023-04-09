package com.example.disneyapp.UI.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.disneyapp.Data.local.Entity.DisneyEntity
import com.example.disneyapp.Data.remote.Model.DisneyData
import com.example.disneyapp.R
import com.example.disneyapp.Util.OnItemClick
import com.example.disneyapp.databinding.RecyclerRowBinding

class FragmentAdapter(
    private val dataList : List<DisneyData>?,
    private val entityList : List<DisneyEntity>?,
    private val listener: OnItemClick
    ) : RecyclerView.Adapter<FragmentAdapter.FragmentViewHolder>(){

    class FragmentViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = RecyclerRowBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FragmentViewHolder {
        return FragmentViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_row, parent, false)
        )
    }

    override fun getItemCount(): Int {
        if (dataList != null){
            return dataList.size
        }else{
            return entityList!!.size
        }
    }

    override fun onBindViewHolder(holder: FragmentViewHolder, position: Int) {
        if (dataList != null){
            Glide.with(holder.itemView.context)
                .load(dataList.get(position).imageUrl)
                .error(R.drawable.ic_launcher_background)
                .into(holder.binding.imageView)

            holder.binding.textView.text = dataList.get(position).name ?: ""

            holder.binding.recyclerRow.setOnClickListener {
                listener.clickListener(dataList.get(position)._id!!)
            }
        }else{
            Glide.with(holder.itemView.context)
                .load(entityList?.get(position)?.imageUrl)
                .error(R.drawable.ic_launcher_background)
                .into(holder.binding.imageView)

            holder.binding.textView.text = entityList?.get(position)?.name ?: ""

            holder.binding.recyclerRow.setOnClickListener {
                listener.clickListener(entityList?.get(position)?.id!!)
            }
        }
    }
}