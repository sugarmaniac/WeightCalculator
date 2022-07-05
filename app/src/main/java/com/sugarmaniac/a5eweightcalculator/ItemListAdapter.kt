package com.sugarmaniac.a5eweightcalculator

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text


class Adapter(
    val context: Context,
    val itemNameList: Array<String> = context.resources.getStringArray(R.array.deneme),
    val itemWeightList: IntArray = context.resources.getIntArray(R.array.integerarray),
    val clickListener: ClickListener,
    val itemNumbers: MutableLiveData<Array<Int>> = MutableLiveData(arrayOf(0))
) : RecyclerView.Adapter<Adapter.ModelViewHolder>() {

    interface ClickListener{
        fun increaseClicked(int: Int)
        fun decreaseClicked(int: Int)
    }

    class ModelViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemName: TextView = view.findViewById(R.id.item_name_text)
        val itemWeight: TextView = view.findViewById(R.id.item_weight_text)
        val itemNumber: TextView = view.findViewById(R.id.item_number)
        val itemWeightTotal: TextView = view.findViewById(R.id.total_weight_text)

        val increaseButton : ImageView = view.findViewById(R.id.increase_item_count_button)
        val decreaseButton : ImageView = view.findViewById(R.id.reduce_item_count_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_select_layout, parent, false)
        return ModelViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemNameList.size
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        holder.itemName.text = itemNameList[position]
        holder.itemWeight.text = itemWeightList[position].toString()
        holder.increaseButton.setOnClickListener{ clickListener.increaseClicked(position) }
        holder.decreaseButton.setOnClickListener{clickListener.decreaseClicked(position)}
    }
}