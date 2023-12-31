package com.example.presenter

import com.example.MainContract
import com.example.model.Database
import com.example.model.Person


// Model과 View를 연결하여 Presenter 기능 수행
class MainPresenter(private val database: Database, private val view: MainContract.View) :
    MainContract.Presenter {

    init {
        database.setOnDatabaseListener(object : Database.DatabaseListener {
            override fun onChanged() {
                view.notifyDataChanged()
            }
        })
    }


    override fun load() {
        view.showPersonList(database.getPersonList())
    }

    override fun addPerson(person: Person) {
        database.add(person)
    }

    override fun removePerson(person: Person) {
        database.remove(person)
    }
}