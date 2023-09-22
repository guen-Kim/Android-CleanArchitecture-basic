package com.example.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.RecyclerView
import com.example.MainContract
import com.example.model.Database
import com.example.model.Person
import com.example.mvp_basic.R
import com.example.presenter.MainPresenter
import java.util.Random

class MainActivity : AppCompatActivity(), MainViewHolder.HolderClickListener, MainContract.View {

    private lateinit var rc: RecyclerView
    private lateinit var adapter: MainAdapter
    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rc = findViewById<RecyclerView>(R.id.rc)
        adapter = MainAdapter(this)
        rc.adapter = adapter
        presenter = MainPresenter(Database.getInstance(), this)
        presenter.load()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        presenter.addPerson(Person("Add guen", Random().nextInt(30)))
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add("Add")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onDeleteClick(person: Person?) {
        person?.let { presenter.removePerson(it) }
    }

    override fun showPersonList(personList: List<Person>) {
        adapter.setItems(personList)
    }

    override fun notifyDataChanged() {
        adapter.notifyDataSetChanged()
    }
}