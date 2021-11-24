package com.example.to_do_application

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
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
        binding=DataBindingUtil.inflate(layoutInflater,R.layout.fragment_add,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

  binding.done.setOnClickListener {


//        var addNewTask1 = Tasks(sharedViewModel.taskTitle.value!!,sharedViewModel.taskCreationDate.value!!,sharedViewModel.taskDueDate.value!!,
//        taskStatus = false,sharedViewModel.taskDescripton.value!!)

          var addNewTask1 = Tasks(binding.titleOftask.text.toString(),binding.creationDateOftask.text.toString(),binding.dueDateOftask.text.toString(),
          taskStatus = false,binding.descriptionOftask.text.toString())


        sharedViewModel.addNewTask(addNewTask1)

      val action = AddFragmentDirections.actionAddFragmentToTasksListFragment()

      view.findNavController().navigate(action)

      }
    }
}
