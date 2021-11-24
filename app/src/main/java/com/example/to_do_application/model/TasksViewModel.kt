package com.example.to_do_application.model

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.NavHostFragment
import com.example.to_do_application.R
import com.example.to_do_application.data.DataSource
import userTask
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

class TasksViewModel : ViewModel() {

    //task title
     val taskTitle = MutableLiveData<String>()

    //task duraation
    val taskCreationDate = MutableLiveData<String>()


    val taskDueDate = MutableLiveData<String>()


    //indicate task completed or not
    val taskStatus = MutableLiveData<Boolean>()


    //description of the task
    val taskDescripton = MutableLiveData<String>()



    fun displayTask(title: String) {

        var currentTask = DataSource().loadTasks().find { it.taskTitle == title }
        var currentCdate = DataSource().loadTasks().find { it.taskCreationDate == title }
        var currentDdate = DataSource().loadTasks().find { it.taskDueDate == title }
        var currentTd = DataSource().loadTasks().find { it.description == title }

        taskTitle.value = currentTask?.taskTitle
        taskCreationDate.value = currentCdate?.taskCreationDate
        taskDueDate.value = currentDdate?.taskDueDate
        taskDescripton.value = currentTd?.description
    }


    fun editTask(title : String){

        var currentTask = DataSource().loadTasks().find { it.taskTitle == title }
        var currentCdate = DataSource().loadTasks().find { it.taskCreationDate == title }
        var currentDdate = DataSource().loadTasks().find { it.taskDueDate == title }
        var currentTd = DataSource().loadTasks().find { it.description == title }

        taskTitle.value = currentTask?.taskTitle
        taskCreationDate.value = currentCdate?.taskCreationDate
        taskDueDate.value = currentDdate?.taskDueDate
        taskDescripton.value = currentTd?.description

    }


    fun addNewTask(newTask: Tasks) {

        userTask.add(newTask)

    }



    @RequiresApi(Build.VERSION_CODES.N)
    fun deleteTask(taskChosen : Tasks){

        userTask.removeIf{it.taskTitle == taskChosen.taskTitle}
    }
}
