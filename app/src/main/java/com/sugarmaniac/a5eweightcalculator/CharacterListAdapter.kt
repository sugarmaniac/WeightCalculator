package com.sugarmaniac.a5eweightcalculator

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView


class CharacterListAdapter(
    val context: Context,
    val characterList: LiveData<List<CharacterEntitity>>,
    val characterClickListener: CharacterClickListener
) : RecyclerView.Adapter<CharacterListAdapter.ModelViewHolder>() {

    interface CharacterClickListener{
        fun characterClicked(position: Int)
    }

    class ModelViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val characterName = view.findViewById<TextView>(R.id.character_name_text)
        val characterMaxWeight = view.findViewById<TextView>(R.id.character_weight_text)
        val characterCurrentWeight = view.findViewById<TextView>(R.id.total_weight_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.character_list_layout, parent, false)
        return ModelViewHolder(view)
    }

    override fun getItemCount(): Int {
        return characterList.value!!.size
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        holder.characterName.text = characterList.value?.get(position)?.name
        holder.characterMaxWeight.text = characterList.value?.get(position)?.maxWeight.toString()

        holder.itemView.setOnClickListener{
            characterClickListener.characterClicked(position)
        }
    }
}