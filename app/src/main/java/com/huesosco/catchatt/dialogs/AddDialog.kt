package com.huesosco.catchatt.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.huesosco.catchat.recycler.RecyclerAdapter
import com.huesosco.catchat.recycler.RecyclerItemData
import com.huesosco.catchatt.R
import com.huesosco.catchatt.recycler.SwipeToDeleteCallback


class AddDialog(private val addList: ArrayList<RecyclerItemData>, private val mainAdapter: RecyclerAdapter): DialogFragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val dialogView = inflater.inflate(R.layout.dialog_add, container, false)

        setUpButton(dialogView)
        setUpRecyclerView(dialogView)

        return dialogView
    }


    private fun setUpRecyclerView(v: View){

        val recyclerView = v.findViewById<RecyclerView>(R.id.dialog_add_recycler_view)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(v.context)
        recyclerView.setItemViewCacheSize(15)

        val adapter = RecyclerAdapter(v.context, addList, "ADD", mainAdapter)

        val itemTouchHelper = ItemTouchHelper(SwipeToDeleteCallback(adapter))
        itemTouchHelper.attachToRecyclerView(recyclerView)

        recyclerView.adapter = adapter
    }


    private fun setUpButton(v: View){

        val okButton = v.findViewById<Button>(R.id.dialog_add_ok_button)
        okButton.setOnClickListener {
            dismiss()
        }

    }

}