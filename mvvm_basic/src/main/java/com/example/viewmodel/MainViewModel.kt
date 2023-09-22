package com.example.viewmodel

import androidx.databinding.BaseObservable
import com.example.model.Database
import com.example.model.Person

class MainViewModel(private val database: Database) : BaseObservable() {

    private val items: MutableList<Person> = ArrayList()

    init {
        database.setOnDatabaseListener(object : Database.DatabaseListener {
            override fun onChanged() {
                load()
            }
        })
    }

    fun load() {
        items.clear()
        items.addAll(database.getPersonList())
        notifyChange()
    }

    fun addPerson(person: Person) {
        database.add(person)
    }

    fun removePerson(person: Person) {
        database.remove(person)
    }

    fun getItems(): List<Person> {
        return items
    }
}