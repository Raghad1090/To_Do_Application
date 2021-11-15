package com.example.to_do_application.UI

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.to_do_application.R
import com.example.to_do_application.adapter.ItemAdapter
import com.example.to_do_application.data.DataSource
import com.example.to_do_application.databinding.FragmentTasksListBinding
import com.example.to_do_application.model.TasksViewModel


private lateinit var navController: NavController

class TasksListFragment : Fragment() {

    //delegate property
    private val sharedViewModel: TasksViewModel by activityViewModels()

    //another way to use binding
//    private var binding: FragmentTasksListBinding? = null

    private lateinit var binding: FragmentTasksListBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentTasksListBinding.inflate(inflater, container, false)
        return binding.root

        //var button = findViewById<Button>(R.id.addButton)

        //button.setOnClickListener{}

        //another way to use binding
//        val fragmentBinding = FragmentTasksListBinding.inflate(inflater, container, false)
//        binding = fragmentBinding
//        return fragmentBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

         val myDataset = DataSource().loadTasks()

        binding.recyclerView.adapter = ItemAdapter(requireContext(), myDataset)


        //another way to use binding
//        binding?.TasksListFragment = this

    }

    fun addTaskToList(task:String){

    }

    companion object {

    }

    override fun onDestroyView() {
        super.onDestroyView()
//        binding = null
    }


}

