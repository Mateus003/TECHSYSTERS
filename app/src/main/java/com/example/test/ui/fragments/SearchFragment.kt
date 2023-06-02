package com.example.test.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.test.R
import com.example.test.databinding.FragmentChooseMentorBinding
import com.example.test.databinding.FragmentHomeBinding
import com.example.test.databinding.FragmentSearchBinding


class SearchFragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.view.setOnClickListener(this)
        binding.textNewMentor.setOnClickListener(this)



    }

    override fun onClick(v: View) {
        if (v.id == R.id.view || v.id == R.id.text_new_mentor){
            findNavController().navigate(R.id.action_page_search_to_chooseMentorFragment)
        }
    }


}