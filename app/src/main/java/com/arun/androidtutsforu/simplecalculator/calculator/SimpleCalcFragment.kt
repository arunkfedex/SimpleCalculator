package com.arun.androidtutsforu.simplecalculator.calculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.arun.androidtutsforu.simplecalculator.R
import com.arun.androidtutsforu.simplecalculator.databinding.FragmentSimpleCalcBinding

class SimpleCalcFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSimpleCalcBinding.inflate(inflater,container,false)
        val viewModel :SimpleCalcViewModel by activityViewModels()
        binding.simpleCalcViewModel =viewModel
        binding.setLifecycleOwner(this)

        return binding.root
    }


}