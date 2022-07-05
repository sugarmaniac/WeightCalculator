package com.sugarmaniac.a5eweightcalculator.ui.characterselect

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.sugarmaniac.a5eweightcalculator.GeneralViewModel
import com.sugarmaniac.a5eweightcalculator.R
import com.sugarmaniac.a5eweightcalculator.databinding.FragmentCharacterSelectBinding

class CharacterSelect : Fragment() {

    private var binding : FragmentCharacterSelectBinding? = null

    private val viewModel: GeneralViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCharacterSelectBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initButtons()

    }

    private fun initButtons() {
        binding!!.newCharacterButton.setOnClickListener {
            findNavController().navigate(R.id.action_characterSelect_to_newCharacter)
        }
        binding!!.existingCharacterButton.setOnClickListener{
            findNavController().navigate(R.id.action_characterSelect_to_characterDetails)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null;
    }
}