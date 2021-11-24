package com.example.to_do_application.ui

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.to_do_application.AddFragmentDirections
import com.example.to_do_application.R
import com.example.to_do_application.databinding.FragmentDisplayDetailsBinding
import com.example.to_do_application.databinding.FragmentTaskDescriptionBinding
import com.example.to_do_application.model.Tasks
import com.example.to_do_application.model.TasksViewModel


class TaskDescriptionFragment : Fragment() {

    //edit page

    private val sharedViewModel: TasksViewModel by activityViewModels()

    private lateinit var navController: NavController

    private lateinit var binding: FragmentTaskDescriptionBinding

    //to get arg values
    private lateinit var userTask1: String



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

            userTask1 = it.getString("taskTitleE")!!

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= DataBindingUtil.inflate(layoutInflater,
            R.layout.fragment_task_description,container,false)
        return binding.root

    }


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.viewModel=sharedViewModel
        binding.lifecycleOwner=viewLifecycleOwner

        sharedViewModel.editTask(userTask1)



        //delet task when click
        binding.deleteTaskButton.setOnClickListener {


//            var taskToDelet = Tasks(sharedViewModel.taskTitle.value!!,sharedViewModel.cDate.value!!,sharedViewModel.dDate.value!!
//            ,sharedViewModel.tStatus.value!!,sharedViewModel.taskDescripton.value!!)

            var taskToDelet = Tasks(binding.editTaskTitle.text.toString(),"",binding.editDueDate.text.toString(),
            taskStatus = false,binding.editTaskDetails.text.toString())

            sharedViewModel.deleteTask(taskToDelet)

            val action = TaskDescriptionFragmentDirections.actionTaskDescriptionFragmentToTasksListFragment()

            view.findNavController().navigate(action)
        }

    }

    companion object {
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}

