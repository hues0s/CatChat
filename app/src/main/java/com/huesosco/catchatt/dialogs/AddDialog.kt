package com.huesosco.catchatt.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.huesosco.catchatt.recycler.RecyclerAdapterMain
import com.huesosco.catchat.recycler.RecyclerItemData
import com.huesosco.catchatt.MainActivity
import com.huesosco.catchatt.R
import com.huesosco.catchatt.recycler.RecyclerAdapterAdd


class AddDialog(private val addList: ArrayList<RecyclerItemData>,
                private val checkedItemList: ArrayList<Boolean>,
                private val mainAdapter: RecyclerAdapterMain): DialogFragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val dialogView = inflater.inflate(R.layout.dialog_add, container, false)

        val adapterAdd = RecyclerAdapterAdd(dialogView.context, addList, checkedItemList, mainAdapter)

        setUpRecyclerView(dialogView, adapterAdd)
        setUpButton(dialogView, adapterAdd)

        return dialogView
    }


    private fun setUpRecyclerView(v: View, adapterAdd: RecyclerAdapterAdd){

        val recyclerView = v.findViewById<RecyclerView>(R.id.dialog_add_recycler_view)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(v.context)
        recyclerView.setItemViewCacheSize(15)

        recyclerView.adapter = adapterAdd
    }


    private fun setUpButton(v: View, adapterAdd: RecyclerAdapterAdd){

        val okButton = v.findViewById<Button>(R.id.dialog_add_ok_button)
        okButton.setOnClickListener {

            var i = 0
            while(i < checkedItemList.size){
                if(checkedItemList[i]) adapterAdd.addObj(i)
                else adapterAdd.removeObj(i)
                ++i
            }

            dismiss()
        }

    }

}