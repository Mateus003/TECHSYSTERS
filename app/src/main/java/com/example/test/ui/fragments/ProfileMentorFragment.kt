package com.example.test.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.test.R
import com.example.test.databinding.FragmentChooseMentorBinding
import com.example.test.databinding.FragmentHomeBinding
import com.example.test.databinding.FragmentProfileMentorBinding


class ProfileMentorFragment : Fragment(),View.OnClickListener {
    private var _binding: FragmentProfileMentorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileMentorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.markMentor.setOnClickListener(this)
        binding.toolbar.setOnClickListener(this)
    }


    override fun onClick(v: View) {
        if (v.id == R.id.mark_mentor){
            findNavController().navigate(R.id.action_profileMentorFragment_to_calendarFragment)
        } else if (v.id == R.id.toolbar){
            findNavController().navigate(R.id.action_profileMentorFragment_to_chooseMentorFragment)
        }
    }





}