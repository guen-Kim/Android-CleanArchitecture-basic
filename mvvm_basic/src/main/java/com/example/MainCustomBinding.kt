package com.example

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.model.Person
import com.example.view.MainAdapter

object MainCustomBinding {
    @BindingAdapter("items")
    @JvmStatic
    fun setItems(recyclerView: RecyclerView, items: List<Person>?) {
        val adapter = recyclerView.adapter as? MainAdapter
        items?.let {
            adapter?.setItems(it)
        }
    }
}





