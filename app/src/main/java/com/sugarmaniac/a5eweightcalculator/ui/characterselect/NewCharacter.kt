package com.sugarmaniac.a5eweightcalculator.ui.characterselect

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.AttributeSet
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import com.sugarmaniac.a5eweightcalculator.CharacterEntitity
import com.sugarmaniac.a5eweightcalculator.GeneralViewModel
import com.sugarmaniac.a5eweightcalculator.R


class NewCharacter : Fragment() {

    private val viewModel: GeneralViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_new_character, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        view?.findViewById<Button>(R.id.new_character_button)?.setOnClickListener{
            val name = view?.findViewById<EditText>(R.id.new_character_name_et)
            val maxWeight = view?.findViewById<EditText>(R.id.new_character_max_weight_et)

            viewModel.addCharacter(
                CharacterEntitity(name = name?.text.toString(), maxWeight = maxWeight?.text.toString().toInt())
            )
        }
    }

}