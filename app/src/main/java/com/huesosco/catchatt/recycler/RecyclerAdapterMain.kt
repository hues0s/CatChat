package com.huesosco.catchatt.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.huesosco.catchat.recycler.RecyclerItemData
import com.huesosco.catchatt.MainActivity
import com.huesosco.catchatt.R


class RecyclerAdapterMain(c: Context, l : ArrayList<RecyclerItemData>,
                          private val addPersonList: ArrayList<RecyclerItemData>, private val checkedItemList: ArrayList<Boolean>):
    RecyclerView.Adapter<RecyclerAdapterMain.ViewHolder>() {

    private val context: Context = c
    val list = l

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


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val cardView: CardView = view.findViewById(R.id.recycler_item_cardview)
        val image: ImageView = view.findViewById(R.id.recycler_item_image)
        val name: TextView = view.findViewById(R.id.recycler_item_name)

    }

}