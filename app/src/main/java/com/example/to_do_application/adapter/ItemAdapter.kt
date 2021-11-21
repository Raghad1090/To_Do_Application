package com.example.to_do_application.adapter

import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.to_do_application.R
import com.example.to_do_application.ui.TasksListFragmentDirections
import com.example.to_do_application.model.Tasks

class ItemAdapter(
    private val context: Context,
    private val dataset: List<Tasks>)
    : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {


    class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        val taskTitleTextView: TextView = view.findViewById(R.id.taskTitleview)
        val CheckBox: CheckBox = view.findViewById(R.id.taskStatus)

        val editTaskButton: ImageView = view.findViewById(R.id.editTaskButton)
        val deleteTaskButton: ImageView = view.findViewById(R.id.deleteTaskButton)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)

    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        //hold data
        val item = dataset[position]

        holder.taskTitleTextView.text = item.taskTitle

        //open task details display page
        holder.taskTitleTextView.setOnClickListener {

            val action = TasksListFragmentDirections.actionTasksListFragmentToDisplayDetailsFragment(
                item.taskTitle)
            holder.view.findNavController().navigate(action)

        }

        //open task details edit page
        holder.editTaskButton.setOnClickListener {

//            val action = TasksListFragmentDirections.actionTasksListFragmentToTaskDescriptionFragment(
//                item.taskTitle)
//            holder.view.findNavController().navigate(action)

        }


        //delet task when click
        holder.deleteTaskButton.setOnClickListener {


        }




        holder.CheckBox.setOnClickListener { }


    }



    fun openDetailsPage() {

//      findNavController().navigate(R.id.action_tasksListFragment_to_taskDescriptionFragment)

    //var openEditPage = TaskDescriptionFragmentDirection.action_tasksListFragment_to_taskDescriptionFragment
    }



    //delete fun
    private fun deleteTask(position: Int) {


    }

    private fun checkedTaskCompleted(taskStaus: Boolean) {

    }


   override fun getItemCount() = dataset.size

}