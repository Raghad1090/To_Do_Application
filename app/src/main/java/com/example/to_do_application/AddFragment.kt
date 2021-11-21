package com.example.to_do_application

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.to_do_application.databinding.FragmentAddBinding
import com.example.to_do_application.databinding.FragmentDisplayDetailsBinding
import com.example.to_do_application.model.Tasks
import com.example.to_do_application.model.TasksViewModel
import com.example.to_do_application.ui.TasksListFragmentDirections

class AddFragment : Fragment() {


    private val sharedViewModel: TasksViewModel by activityViewModels()

    private lateinit var navController: NavController

    private lateinit var binding: FragmentAddBinding


    //to get arg values
    private lateinit var userTitleAdd: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

            userTitleAdd = it.getString("taskTitleAdd")!!

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//  binding.done.setOnClickListener{
//
//        val action = AddFragmentDirections.actionAddFragmentToTasksListFragment()
//
//        view.findNavController().navigate(action)
//
//        var addNewTask = Tasks(sharedViewModel.taskTitle.value!!,sharedViewModel.cDate.value!!,sharedViewModel.dDate.value!!,
//            taskStatus = false,sharedViewModel.taskDescripton.value!!)
//
//        sharedViewModel.addNewTask(addNewTask)
//
//        }
    }

    }
