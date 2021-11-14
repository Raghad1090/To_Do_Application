package com.example.to_do_application

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Contacts
import androidx.recyclerview.widget.RecyclerView
import com.example.to_do_application.adapter.ItemAdapter
import com.example.to_do_application.data.DataSource
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myDataset = DataSource().loadTasks()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = ItemAdapter(Context, myDataset)

        recyclerView.setHasFixedSize(true)
    }
}