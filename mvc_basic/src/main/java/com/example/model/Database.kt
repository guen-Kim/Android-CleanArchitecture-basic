package com.example.model

class Database private constructor() {

    private var databaseListener: DatabaseListener? = null


    private val personList = ArrayList<Person>()
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

    fun getPersonList():ArrayList<Person> {
        return personList
    }


    fun add(person: Person) {
        personList.add(0, person)
        notifyChange()
    }

    fun remove(person: Person) {
        personList.remove(person)
        notifyChange()
    }


    fun setOnDatabaseListener(databaseListener: DatabaseListener?) {
        this.databaseListener = databaseListener
    }


    private fun notifyChange() { //데이터 베이스 수정
        databaseListener?.onChanged()
    }

    interface DatabaseListener {
        fun onChanged()
    }

}