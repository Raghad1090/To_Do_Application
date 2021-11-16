package com.example.to_do_application.model

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import com.example.to_do_application.R
import userTask

class TasksViewModel : ViewModel() {



    fun addTaskToList( task : Tasks){

        userTask.add(task)
// or in view model
    }


}
