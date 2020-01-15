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


class RecyclerAdapterAdd(c: Context, l : ArrayList<RecyclerItemData>, cil: ArrayList<Boolean>, private val mainAdapter: RecyclerAdapterMain):
    RecyclerView.Adapter<RecyclerAdapterAdd.ViewHolder>() {

    private val context: Context = c
    val list = l

    private var checkedItemList = cil

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.recycler_item_add, parent, false)
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

        if (checkedItemList[position]) holder.tickImage.visibility = View.VISIBLE

        holder.cardView.setOnClickListener {
            if(!checkedItemList[position]) {
                holder.tickImage.visibility = View.VISIBLE
                checkedItemList[position] = true
            }
            else {
                holder.tickImage.visibility = View.INVISIBLE
                checkedItemList[position] = false
            }
        }

    }

    fun addObj(position: Int){
        if(!mainAdapter.list.contains(list[position])) mainAdapter.list.add(list[position])
        mainAdapter.notifyDataSetChanged()
    }

    fun removeObj(position: Int){
        if(mainAdapter.list.contains(list[position])) mainAdapter.list.remove(list[position])
        mainAdapter.notifyDataSetChanged()
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val cardView: CardView = view.findViewById(R.id.recycler_item_add_cardview)
        val image: ImageView = view.findViewById(R.id.recycler_item_add_image)
        val name: TextView = view.findViewById(R.id.recycler_item_add_name)
        val tickImage: ImageView = view.findViewById(R.id.recycler_item_add_done)

    }

}