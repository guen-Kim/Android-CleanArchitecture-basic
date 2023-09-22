package com.example.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.example.model.Database
import com.example.model.Person
import com.example.mvvm_basic.R
import com.example.mvvm_basic.databinding.ActivityMainBinding
import com.example.viewmodel.MainViewModel
import java.util.Random

class MainActivity : AppCompatActivity() , MainViewHolder.HolderClickListener {
    companion object {
        private const val TAG = "MainActivity"
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MainAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        adapter = MainAdapter(this)
        binding.rc.adapter = adapter

        viewModel = MainViewModel(Database.getInstance())
        binding.viewModel = viewModel

        viewModel.load()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menu.add("Add")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        viewModel.addPerson(Person("addguen", Random().nextInt(100)))
        return super.onOptionsItemSelected(item)
    }

    override fun onDeleteClick(person: Person?) {
        if (person != null) {
            viewModel.removePerson(person)
        }
    }
}