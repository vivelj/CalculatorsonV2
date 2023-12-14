package com.example.calculatorofson

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val dataSet: Array<String>) : RecyclerView.Adapter<ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tablelist, parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = dataSet[position]
        holder.textView.setTextColor(ContextCompat.getColor(holder.textView.context, R.color.white))
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

    val textView: TextView

    init {
        // Define click listener for the ViewHolder's View
        textView = view.findViewById(R.id.rrrrr)
    }


}

