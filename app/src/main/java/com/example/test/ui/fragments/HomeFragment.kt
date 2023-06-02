package com.example.test.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.test.R
import com.example.test.databinding.FragmentHomeBinding

class HomeFragment : Fragment(),View.OnClickListener {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.optionBack.setOnClickListener(this)
        binding.optionData.setOnClickListener(this)
        binding.optionFront.setOnClickListener(this)
        binding.optionDesign.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val navController = findNavController()
        val bundle = bundleOf("BOTAO_CLICADO" to getButtonClickedId(v.id))
        navController.navigate(R.id.action_page_home_to_chooseMentorFragment, bundle)
    }

    private fun getButtonClickedId(buttonId: Int): String {
        return when (buttonId) {
            R.id.option_back -> "optionBack"
            R.id.option_data -> "optionData"
            R.id.option_design -> "optionDesign"
            R.id.option_front -> "optionFront"
            else -> ""
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}