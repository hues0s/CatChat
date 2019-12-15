package com.huesosco.catchatt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.huesosco.catchatt.recycler.RecyclerAdapterMain
import com.huesosco.catchat.recycler.RecyclerItemData
import com.huesosco.catchatt.dialogs.AddDialog
import com.huesosco.catchatt.recycler.RecyclerAdapterAdd

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mainList = ArrayList<RecyclerItemData>()
    private var addPersonList = ArrayList<RecyclerItemData>()
    private var checkedItemList = ArrayList<Boolean>()

    private lateinit var adapter: RecyclerAdapterMain



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        fullMainList()
        fullAddList()
        for(i in 0 until addPersonList.size) checkedItemList.add(false)

        setUpRecyclerView()
        val addDialog = AddDialog(addPersonList, checkedItemList, adapter)

        fab.setOnClickListener {
            addDialog.show(supportFragmentManager, "add dialog")
        }

    }

    private fun fullMainList() {

        mainList.add(RecyclerItemData("happy", "Person 1"))
        mainList.add(RecyclerItemData("happy", "Person 2"))
        mainList.add(RecyclerItemData("sad", "Person 3"))
        mainList.add(RecyclerItemData("happy", "Person 4"))
        mainList.add(RecyclerItemData("sad", "Person 5"))
        mainList.add(RecyclerItemData("sad", "Person 6"))
        mainList.add(RecyclerItemData("happy", "Person 7"))
        mainList.add(RecyclerItemData("sad", "Person 8"))
        mainList.add(RecyclerItemData("happy", "Person 9"))
        mainList.add(RecyclerItemData("sad", "Person 10"))

    }

    private fun fullAddList() {

        addPersonList.add(RecyclerItemData("sad", "Person 15"))
        addPersonList.add(RecyclerItemData("happy", "Person 18"))

    }


    private fun setUpRecyclerView(){

        val recyclerView = findViewById<RecyclerView>(R.id.activity_main_recycler_view)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.setItemViewCacheSize(15)

        adapter = RecyclerAdapterMain(applicationContext, mainList, addPersonList, checkedItemList)

        recyclerView.adapter = adapter
    }


}
