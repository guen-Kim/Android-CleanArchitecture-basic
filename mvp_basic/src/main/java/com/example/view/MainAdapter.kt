package com.example.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.model.Person
import com.example.mvp_basic.R

class MainAdapter(private val holderClickListener: MainViewHolder.HolderClickListener) :
    RecyclerView.Adapter<MainViewHolder>() {
    private var items: List<Person> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_activity, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val person = items[position]
        holder.setPerson(person)
        holder.setOnHolderClickListener(holderClickListener)
    }


    fun setItems(items: List<Person>) {
        this.items = items
        this.notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return items.size
    }
}
