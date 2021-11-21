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
    private val _taskTitle = MutableLiveData<String>()
    val taskTitle: LiveData<String> = _taskTitle

    //task duraation
    private val _taskCreationDate = MutableLiveData<String>()
    val cDate: LiveData<String> = _taskCreationDate

    private val _taskDueDate = MutableLiveData<String>()
    val dDate: LiveData<String> = _taskDueDate


    //indicate task completed or not
    private val _taskStatus = MutableLiveData<Boolean>()
    val tStatus: LiveData<Boolean> = _taskStatus

    //description of the task
    private val _taskDescripton = MutableLiveData<String>()
    val taskDescripton: LiveData<String> = _taskDescripton


    fun displayTask(title: String) {

        var currentTask = DataSource().loadTasks().find { it.taskTitle == title }
        var currentCdate = DataSource().loadTasks().find { it.taskCreationDate == title }
        var currentDdate = DataSource().loadTasks().find { it.taskDueDate == title }
        var currentTd = DataSource().loadTasks().find { it.description == title }

        _taskTitle.value = currentTask?.taskTitle
        _taskCreationDate.value = currentCdate?.taskCreationDate
        _taskDueDate.value = currentDdate?.taskDueDate
        _taskDescripton.value = currentTd?.description
    }


    fun editTask(title : String){

        var currentTask = DataSource().loadTasks().find { it.taskTitle == title }
        var currentCdate = DataSource().loadTasks().find { it.taskCreationDate == title }
        var currentDdate = DataSource().loadTasks().find { it.taskDueDate == title }
        var currentTd = DataSource().loadTasks().find { it.description == title }

        _taskTitle.value = currentTask?.taskTitle
        _taskCreationDate.value = currentCdate?.taskCreationDate
        _taskDueDate.value = currentDdate?.taskDueDate
        _taskDescripton.value = currentTd?.description

    }


    fun addNewTask(newTask: Tasks) {

        userTask.add(newTask)

    }



    @RequiresApi(Build.VERSION_CODES.N)
    fun deleteTask(taskChosen : Tasks){

        userTask.removeIf{it.taskTitle == taskChosen.taskTitle}
    }
}
