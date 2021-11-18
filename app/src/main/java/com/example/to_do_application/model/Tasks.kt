package com.example.to_do_application.model

import android.os.SystemClock
import java.text.DateFormat

data class Tasks (val taskTitle:String,
                  val taskCreationDate: String,
                  val taskDueDate: String,
                  val taskStatus: Boolean,
                  val description : String){



//    Long = System.currentTimeMillis()
//    val date : String
//
//    get() = DateFormat.getDateTimeInstance().format(taskCreationDate)

}