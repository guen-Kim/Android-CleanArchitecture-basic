package com.example


import com.example.model.Person

class MainContract {

    interface View {
        fun showPersonList(personList: List<Person>)
        fun notifyDataChanged()
    }

    interface Presenter {
        fun load()
        fun addPerson(person: Person)
        fun removePerson(person: Person)
    }

}