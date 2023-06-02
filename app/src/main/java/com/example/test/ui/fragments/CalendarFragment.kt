package com.example.test.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CalendarView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.test.R
import com.example.test.databinding.FragmentCalendarBinding
import com.example.test.databinding.FragmentProfileMentorBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.util.Calendar


class CalendarFragment : Fragment(), View.OnClickListener {
    private lateinit var bottomSheetDialog: BottomSheetDialog
    private lateinit var bottomSheetView: View

    private var _binding: FragmentCalendarBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCalendarBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val calendarView = binding.calendar
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            showBottomSheetDialog() // Exibir o BottomSheetDialog ao clicar em um dia do calendário
        }

        binding.toolbar.setOnClickListener(this)

    }




    private fun showBottomSheetDialog() {
        // Inflar o layout do BottomSheetDialog
        bottomSheetView = layoutInflater.inflate(R.layout.bottom_sheet_time_picker, null)

        // Configurar o comportamento do BottomSheetDialog
        bottomSheetDialog = BottomSheetDialog(requireContext())
        bottomSheetDialog.setContentView(bottomSheetView)

        // Configurar a ação do botão de confirmar
        val buttonConfirm = bottomSheetView.findViewById<Button>(R.id.button_confirm)
        buttonConfirm.setOnClickListener {

            Toast.makeText(requireContext(), "Você receberá um e-mail com link da mentoria:)", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_calendarFragment_to_page_home)
            bottomSheetDialog.dismiss() // Fechar o BottomSheetDialog após a confirmação
        }

        // Configurar a ação do botão de cancelar
        val buttonCancel = bottomSheetView.findViewById<Button>(R.id.button_cancel)
        buttonCancel.setOnClickListener {
            bottomSheetDialog.dismiss() // Fechar o BottomSheetDialog ao cancelar
        }

        // Exibir o BottomSheetDialog
        bottomSheetDialog.show()
    }

    override fun onClick(v: View) {
        if (v.id ==R.id.toolbar){
            findNavController().navigate(R.id.action_calendarFragment_to_profileMentorFragment)
        }
    }

}