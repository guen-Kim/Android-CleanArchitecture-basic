package com.example.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.model.Database
import com.example.model.Person
import com.example.mvc_basic.R
import com.example.view.MainViewHolder
import java.util.Random

class MainActivity : AppCompatActivity(), MainViewHolder.HolderClickListener {

    private lateinit var rc:RecyclerView
    private lateinit var adapter: MainAdapter
    private val database = Database.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rc = findViewById<RecyclerView>(R.id.rc)
        adapter = MainAdapter(this)
        rc.adapter = adapter
        adapter.setItems(database.getPersonList())


        database.setOnDatabaseListener(object : Database.DatabaseListener {
            override fun onChanged() {
                adapter.setItems(database.getPersonList())
            }
        })
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add("Add")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        database.add(Person( "Add guen", Random().nextInt(30)))
        return super.onOptionsItemSelected(item)
    }

    override fun onDeleteClick(person: Person?) {
        database.remove(person!!)
    }
}