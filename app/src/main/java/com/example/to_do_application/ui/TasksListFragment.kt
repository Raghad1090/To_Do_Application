package com.example.to_do_application.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.to_do_application.R
import com.example.to_do_application.adapter.ItemAdapter
import com.example.to_do_application.data.DataSource
import com.example.to_do_application.databinding.FragmentTasksListBinding
import com.example.to_do_application.model.Tasks
import com.example.to_do_application.model.TasksViewModel


class TasksListFragment : Fragment() {

    //delegate property
    private val sharedViewModel: TasksViewModel by activityViewModels()

    private lateinit var navController: NavController

    private lateinit var binding: FragmentTasksListBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentTasksListBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myDataset = DataSource().loadTasks()

        binding.recyclerView.adapter = ItemAdapter(requireContext(), myDataset)

        binding.addButton.setOnClickListener {

            val action = TasksListFragmentDirections.actionTasksListFragmentToAddFragment("")

            view.findNavController().navigate(action)


        }


    }

    override fun onDestroyView() {
        super.onDestroyView()

    }
}
