package com.example.to_do_application.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.to_do_application.R
import com.example.to_do_application.databinding.FragmentTaskDescriptionBinding
import com.example.to_do_application.databinding.FragmentTasksListBinding
import com.example.to_do_application.model.TasksViewModel


class TaskDescriptionFragment : Fragment() {


    private val sharedViewModel: TasksViewModel by activityViewModels()

//    private var binding: FragmentTaskDescriptionBinding? = null

    private lateinit var binding: FragmentTaskDescriptionBinding


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