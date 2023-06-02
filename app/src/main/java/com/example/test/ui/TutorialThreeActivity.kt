package com.example.test.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.test.R
import com.example.test.databinding.ActivityTutorialThreeBinding

class TutorialThreeActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding : ActivityTutorialThreeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityTutorialThreeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.appCompatButton2.setOnClickListener(this)
        toDefineToolbar()
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.appCompatButton2 -> {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
    }

    private fun toDefineToolbar() {
        val toolbar = binding.toolbar

        setSupportActionBar(toolbar)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_back_dark)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        supportActionBar?.title = null

        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}