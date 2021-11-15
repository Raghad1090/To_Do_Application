package com.example.to_do_application.adapter

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.to_do_application.MainActivity
import com.example.to_do_application.R
import com.example.to_do_application.model.Tasks

 class ItemAdapter(
    private val context: Context,
    private val dataset: List<Tasks>)
    : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        val textView: TextView = view.findViewById(R.id.taskTitleview)
        val CheckBox: CheckBox = view.findViewById(R.id.taskStatus)

    }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

         val adapterLayout = LayoutInflater.from(parent.context)
             .inflate(R.layout.list_item, parent, false)

         return ItemViewHolder(adapterLayout)
     }

     override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

         val item = dataset[position]

         //holder.textView.text = context.resources.getString(item.taskTitle)
     }

     override fun getItemCount() = dataset.size


 }


