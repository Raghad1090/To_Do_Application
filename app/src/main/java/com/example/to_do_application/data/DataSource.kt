package com.example.to_do_application.data

import com.example.to_do_application.model.Tasks

class DataSource {

    fun loadTasks() : List<Tasks>{

        return listOf<Tasks>(

            Tasks("Study","20.11.2021","22.11.2021",false),

            Tasks("data structure project ","22.11.2021","5.12.2021",false)

        )

    }

}