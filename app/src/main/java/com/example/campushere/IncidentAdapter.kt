package com.example.campushere

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.campushere.databinding.RecyclerRowBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

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

        val sdf = SimpleDateFormat("dd.MM.yyyy HH:mm", Locale("tr", "TR"))

        holder.binding.textViewRecyclerTitle.text=incidentList[position].title
        holder.binding.textViewRecyclerDescription.text=incidentList[position].description
        holder.binding.textViewRecyclerStatus.text = incidentList[position].status
        holder.binding.textViewRecyclerDate.text = sdf.format(Date(incidentList[position].date))


    }



}