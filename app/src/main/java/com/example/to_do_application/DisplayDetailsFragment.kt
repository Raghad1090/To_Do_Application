package com.example.to_do_application

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import com.example.to_do_application.databinding.FragmentDisplayDetailsBinding
import com.example.to_do_application.databinding.FragmentTaskDescriptionBinding
import com.example.to_do_application.model.Tasks
import com.example.to_do_application.model.TasksViewModel
import userTask


class DisplayDetailsFragment : Fragment() {

    private val sharedViewModel: TasksViewModel by activityViewModels()



    private lateinit var binding: FragmentDisplayDetailsBinding

    //to get arg values
    private lateinit var userTaskd: String
    private lateinit var userCdate: String
    private lateinit var userDdate: String
    private var userTstatus: Boolean = false
    private lateinit var userTdes: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

            userTaskd = it.getString("taskTitleD")!!



        }



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(layoutInflater,R.layout.fragment_display_details,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel=sharedViewModel
        binding.lifecycleOwner=viewLifecycleOwner

        sharedViewModel.displayTask(userTaskd)
    }


}
