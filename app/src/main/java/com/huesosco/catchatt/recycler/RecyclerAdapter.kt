package com.huesosco.catchat.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.huesosco.catchatt.MainActivity
import com.huesosco.catchatt.R


class RecyclerAdapter(c: Context, l : ArrayList<RecyclerItemData>,
                      private val adapterType: String, private val otherAdapter: RecyclerAdapter?):
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private val context: Context = c
    private val list = l

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val imageResource = if(list[position].image == "happy")
            R.drawable.ic_happy_cat
        else R.drawable.ic_sad_cat

        holder.image.setImageResource(imageResource)
        holder.name.text = list[position].name

        holder.cardView.setOnClickListener {
            //to be added...
        }

    }

    fun deleteItem(position: Int){

        when(adapterType){
            "MAIN" -> {
                MainActivity.addPersonList.add(MainActivity.mainList.removeAt(position))
                notifyItemRemoved(position)
            }
            "ADD" -> {
                MainActivity.mainList.add(MainActivity.addPersonList.removeAt(position))
                notifyItemRemoved(position)
                otherAdapter?.notifyItemInserted(MainActivity.mainList.size - 1)
            }
        }

    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val cardView = view.findViewById<CardView>(R.id.recycler_item_cardview)

        val image = view.findViewById<ImageView>(R.id.recycler_item_image)
        val name = view.findViewById<TextView>(R.id.recycler_item_name)

    }

}