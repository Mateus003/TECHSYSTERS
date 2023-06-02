package com.example.test.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.test.R
import com.example.test.databinding.ActivityIntroductionBinding

class IntroductionActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var binding : ActivityIntroductionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroductionBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.appCompatButton.setOnClickListener(this)


    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.appCompatButton -> {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }


}