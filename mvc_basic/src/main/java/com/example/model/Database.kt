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
        // DB 데이터가 바뀌었다. 사용자에게 보여지는 데이터도 바껴야한다.
        // model은 view에 의존하지 않으므로 view에 데이터 전달하는 로직 controller에서 처리 하도록 전가
        notifyChange()
    }

    fun remove(person: Person) {
        personList.remove(person)
        notifyChange()
    }


    fun setOnDatabaseListener(databaseListener: DatabaseListener?) {
        this.databaseListener = databaseListener
    }


    private fun notifyChange() { //데이터 베이스 변경 알림
        databaseListener?.onChanged()
    }

    interface DatabaseListener {
        fun onChanged()
    }

}