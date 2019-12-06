package com.huesosco.catchatt.recycler


import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.huesosco.catchat.recycler.RecyclerAdapter



class SwipeToDeleteCallback(private val recyclerAdapter: RecyclerAdapter): ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {


    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

        val position = viewHolder.adapterPosition
        recyclerAdapter.deleteItem(position)

    }

    override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
        return true
    }



}