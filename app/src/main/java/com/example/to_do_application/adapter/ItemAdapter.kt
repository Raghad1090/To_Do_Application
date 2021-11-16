package com.example.to_do_application.adapter

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.to_do_application.MainActivity
import com.example.to_do_application.R
import com.example.to_do_application.model.Tasks
import org.w3c.dom.Text

class ItemAdapter(
    private val context: Context,
    private val dataset: List<Tasks>)
    : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        val taskTitleTextView: TextView = view.findViewById(R.id.taskTitleview)
        val CheckBox: CheckBox = view.findViewById(R.id.taskStatus)

        val editTaskButton: Button = view.findViewById(R.id.editTaskButton)
        val deleteTaskButton: Button = view.findViewById(R.id.deleteTaskButton)

        val creationDate: TextView = view.findViewById(R.id.DueDate)
        val dueDate: TextView = view.findViewById(R.id.CreationDate)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)

    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        //hold data
        val item = dataset[position]

        holder.editTaskButton.setOnClickListener { openDetailsPage() }
        holder.deleteTaskButton.setOnClickListener { deleteTask() }
        holder.CheckBox.setOnClickListener { checkedTaskCompleted() }
    }

    private fun checkedTaskCompleted(taskStaus: Boolean) {

    }


    fun openDetailsPage() {

      findNavController().navigate(R.id.action_tasksListFragment_to_taskDescriptionFragment)

    }

    private fun deleteTask() {

    }

    override fun getItemCount() = dataset.size

}