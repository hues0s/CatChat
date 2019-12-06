package com.huesosco.catchatt

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.huesosco.catchat.recycler.RecyclerAdapter
import com.huesosco.catchat.recycler.RecyclerItemData
import com.huesosco.catchatt.dialogs.AddDialog
import com.huesosco.catchatt.recycler.SwipeToDeleteCallback

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        var mainList = ArrayList<RecyclerItemData>()
        var addPersonList = ArrayList<RecyclerItemData>()
    }

    private lateinit var adapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        fullMainList()
        fullAddList()

        setUpRecyclerView()

        fab.setOnClickListener {
            AddDialog(addPersonList, adapter).show(supportFragmentManager, "add dialog")
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

        adapter = RecyclerAdapter(applicationContext, mainList, "MAIN", null)

        val itemTouchHelper = ItemTouchHelper(SwipeToDeleteCallback(adapter))
        itemTouchHelper.attachToRecyclerView(recyclerView)

        recyclerView.adapter = adapter
    }


}
