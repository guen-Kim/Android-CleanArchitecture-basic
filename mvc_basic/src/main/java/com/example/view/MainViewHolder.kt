package com.example.view

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.model.Person
import com.example.mvc_basic.R

class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val name: TextView = itemView.findViewById(R.id.tv_name)
    private val age: TextView = itemView.findViewById(R.id.tv_age)
    private val delete: Button = itemView.findViewById(R.id.btn_delete)
    private var listener: HolderClickListener? = null
    private var person: Person? = null


    init {
        delete.setOnClickListener {
            listener?.onDeleteClick(person)
        }
    }

    fun setPerson(person: Person) {
        this.person = person
        name.text = person.name
        age.text = person.age.toString()
    }


    fun setOnHolderClickListener(listener: HolderClickListener) {
        this.listener = listener
    }

    interface HolderClickListener {
        fun onDeleteClick(person: Person?)
    }


}