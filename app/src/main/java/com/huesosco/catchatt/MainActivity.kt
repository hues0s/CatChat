package com.huesosco.catchatt

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.huesosco.catchat.recycler.RecyclerAdapter
import com.huesosco.catchat.recycler.RecyclerItemData
import com.huesosco.catchatt.dialogs.AddDialog

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            AddDialog().show(supportFragmentManager, "add dialog")
        }

        setUpRecyclerView()

    }

    private fun getList(): ArrayList<RecyclerItemData> {

        val list = ArrayList<RecyclerItemData>()

        list.add(RecyclerItemData("happy", "Person 1"))
        list.add(RecyclerItemData("happy", "Person 2"))
        list.add(RecyclerItemData("sad", "Person 3"))
        list.add(RecyclerItemData("happy", "Person 4"))
        list.add(RecyclerItemData("sad", "Person 5"))
        list.add(RecyclerItemData("sad", "Person 6"))
        list.add(RecyclerItemData("happy", "Person 7"))
        list.add(RecyclerItemData("sad", "Person 8"))
        list.add(RecyclerItemData("happy", "Person 9"))
        list.add(RecyclerItemData("sad", "Person 10"))

        return list
    }


    private fun setUpRecyclerView(){

        val recyclerView = findViewById<RecyclerView>(R.id.activity_main_recycler_view)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.setItemViewCacheSize(15)

        val adapter = RecyclerAdapter(applicationContext, getList())

        recyclerView.adapter = adapter
    }


}
