package com.example.to_do_application.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import com.example.to_do_application.databinding.FragmentDisplayDetailsBinding
import com.example.to_do_application.databinding.FragmentTaskDescriptionBinding
import com.example.to_do_application.model.TasksViewModel


class TaskDescriptionFragment : Fragment() {


    private val sharedViewModel: TasksViewModel by activityViewModels()

    private lateinit var navController: NavController

    private lateinit var binding: FragmentTaskDescriptionBinding

    //to get arg values
    private lateinit var userTask1: String
    private lateinit var userCdate1: String
    private lateinit var userDdate1: String
    private var userTstatus1: Boolean =false
    private lateinit var userTdes1: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {


            userTask1 = it.getString("taskTitleE")!!
            userCdate1 = it.getString("cDateE")!!
            userDdate1 = it.getString("dDateE")!!
            userTstatus1 = it.getBoolean("taskSE")
            userTdes1 = it.getString("descriptionE")!!


        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentTaskDescriptionBinding.inflate(inflater, container, false)
        return binding.root


        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_tasks_list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //binding?.FragmentTaskDescriptionBinding = this
    }

    companion object {
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}

