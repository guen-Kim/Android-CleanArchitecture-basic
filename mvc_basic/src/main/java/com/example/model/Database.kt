package com.example.model

class Database private constructor() {

    private val personList = ArrayList<Person>()
    private var databaseListener: DatabaseListener? = null

    init {
        for (index in 0 until 10) {
            personList.add(Person("guen$index", index))
        }
    }


    companion object {

        private var instance: Database? = null;

        fun getInstance(): Database {
            if (instance == null) {
                instance = Database()
            }
            return instance!!
        }
    }


    fun add(person: Person) {
        personList.add(0, person)
        notifyChange()
    }

    fun remove(person: Person) {
        personList.remove(person)
        notifyChange()
    }

    private fun notifyChange() {
        databaseListener?.onChanged()
    }


    private interface DatabaseListener {
        fun onChanged()
    }

}