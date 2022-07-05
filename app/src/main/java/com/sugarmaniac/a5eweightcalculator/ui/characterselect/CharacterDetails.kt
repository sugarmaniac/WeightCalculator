package com.sugarmaniac.a5eweightcalculator.ui.characterselect

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sugarmaniac.a5eweightcalculator.Adapter
import com.sugarmaniac.a5eweightcalculator.GeneralViewModel
import com.sugarmaniac.a5eweightcalculator.R
import com.sugarmaniac.a5eweightcalculator.databinding.FragmentCharacterDetailsBinding
import com.sugarmaniac.a5eweightcalculator.databinding.FragmentCharacterSelectBinding

class CharacterDetails : Fragment(), Adapter.ClickListener {

    private val viewModel : GeneralViewModel by activityViewModels()

    private var binding: FragmentCharacterDetailsBinding? = null
    private var adapter: Adapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterDetailsBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = Adapter(context = requireContext(), clickListener = this)
        val recyclerView = binding!!.itemRv
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
    }

    override fun increaseClicked(int: Int) {
        TODO("Not yet implemented")
    }

    override fun decreaseClicked(int: Int) {
        TODO("Not yet implemented")
    }
}