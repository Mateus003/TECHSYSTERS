package com.example.test.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.adapter.MentorAdapter
import com.example.test.adapter.RecommendationAdapter
import com.example.test.databinding.FragmentChooseMentorBinding
import com.example.test.databinding.FragmentHomeBinding
import com.example.test.model.Mentor
import com.example.test.model.Recommendation


class ChooseMentorFragment : Fragment(), View.OnClickListener,MentorAdapter.MentorClickListener {

    private var _binding: FragmentChooseMentorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseMentorBinding.inflate(inflater, container, false)
        return binding.root
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerViewMentor()

        initRecyclerViewRecommendation()

        binding.rvMentors.setOnClickListener(this)

        binding.toolbar.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.rv_mentors){
            findNavController().navigate(R.id.action_chooseMentorFragment_to_profileMentorFragment)
        } else if (v.id == R.id.toolbar){
            findNavController().navigate(R.id.action_chooseMentorFragment_to_page_home)
        }
    }

    private fun initRecyclerViewMentor(){

        val mentors = mutableListOf<Mentor>()
        val pictureAna = R.drawable.ana_luiza
        val pictureBeatriz  = R.drawable.beatriz
        val pictureCarol = R.drawable.carol


        when (arguments?.getString("BOTAO_CLICADO")) {
            "optionBack" -> {
                mentors.add(Mentor("Ana luiza", "Desenvolvedora sênior Ifood", pictureAna))
                mentors.add(Mentor("Carol", "Desenvolvedora sênior Ifood", pictureCarol))
                mentors.add(Mentor("Beatriz", "Desenvolvedora sênior Ifood", pictureBeatriz))
            }
            "optionData" -> {
                mentors.add(Mentor("Ana luiza", "Cientista de Dados Sênior Ifood", pictureAna))
                mentors.add(Mentor("Carol", "Cientista de Dados Sênior Ifood", pictureCarol))
                mentors.add(Mentor("Beatriz", "Cientista de Dados Sênior Ifood", pictureBeatriz))
            }
            "optionDesign" -> {
                mentors.add(Mentor("Ana luiza", "Design UI/UX Sênior Ifood", pictureAna))
                mentors.add(Mentor("Carol", "Design UI/UX Sênior Ifood", pictureCarol))
                mentors.add(Mentor("Beatriz", "Design UI/UX Sênior Ifood", pictureBeatriz))
            }
            "optionFront" -> {
                mentors.add(Mentor("Ana luiza", "Desenvolvedora Sênior Ifood", pictureAna))
                mentors.add(Mentor("Carol", "Desenvolvedora Sênior Ifood", pictureCarol))
                mentors.add(Mentor("Beatriz", "Desenvolvedora Sênior Ifood", pictureBeatriz))
            }else->{
            mentors.add(Mentor("Ana luiza", "Cientista de Dados Sênior Ifood", pictureAna))
            mentors.add(Mentor("Carol", "Desenvolvedora Sênior Ifood", pictureCarol))
            mentors.add(Mentor("Beatriz", "Design UI/UX Sênior Ifood", pictureBeatriz))
            }
        }





        val adapter = MentorAdapter(mentors,this)

        val rvMentor: RecyclerView = binding.rvMentors
        rvMentor.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rvMentor.adapter = adapter

    }



    private fun initRecyclerViewRecommendation(){
        val nameTech = mutableListOf<Recommendation>()

        nameTech.add(Recommendation("Aprenda sobre o framework Angular.", R.drawable.ic_angular,))
        nameTech.add(Recommendation("Aprendendo a codar em JavaScript.", R.drawable.ic_js))
        nameTech.add(Recommendation("Como ter um bom  perfil no LinkedIn.", R.drawable.ic_linkedin))
        nameTech.add(Recommendation("   Elas empreendem: Mulheres e startups.",R.drawable.ic_women))




        val adapter = RecommendationAdapter(nameTech)

        val rvRecommendation: RecyclerView = binding.rvRecommendation
        rvRecommendation.layoutManager = LinearLayoutManager(requireContext())
        rvRecommendation.adapter = adapter



    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    override fun onMentorClicked(mentor: Mentor) {
        val action = ChooseMentorFragmentDirections.actionChooseMentorFragmentToProfileMentorFragment()
        findNavController().navigate(action)
    }


}