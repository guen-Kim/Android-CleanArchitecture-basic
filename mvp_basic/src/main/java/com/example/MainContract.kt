package com.example


import com.example.model.Person

/*
    Contract Interface: 구성 요소 및 구성 요소가 구현해야 할 역할 정의
    View 와 Presenter를 연결하기 위한 Interface
*/

class MainContract {

    interface View {
        fun showPersonList(personList: List<Person>) // View 에 데이터를 화면에 나타낸다.
        fun notifyDataChanged()  // Presenter에 생명주기 or 클릭 이벤트에 대한 내용을 통지한다.
    }

    interface Presenter {
        fun load() // 미리 저장된 DB 데이터 불러오기(화면 출력)
        fun addPerson(person: Person) // DB에 데이터 저장하기
        fun removePerson(person: Person) // DB에 데이터 삭제하기
    }

}