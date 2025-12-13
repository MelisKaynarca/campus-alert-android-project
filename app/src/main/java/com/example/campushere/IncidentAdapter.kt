package com.example.campushere

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.campushere.databinding.RecyclerRowBinding

class IncidentAdapter(private val incidentList : ArrayList<Incident>) : RecyclerView.Adapter<IncidentAdapter.IncidentViewHolder>() {

    class IncidentViewHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IncidentViewHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return IncidentViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return incidentList.size
    }

    override fun onBindViewHolder(holder: IncidentViewHolder, position: Int) {

        holder.binding.textViewRecyclerTitle.text=incidentList[position].title
        holder.binding.textViewRecyclerDescription.text=incidentList[position].description

    }



}