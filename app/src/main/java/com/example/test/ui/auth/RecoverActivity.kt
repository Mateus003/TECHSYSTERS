package com.example.test.ui.auth

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.test.R
import com.example.test.databinding.ActivityRecoverBinding

class RecoverActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding:ActivityRecoverBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityRecoverBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonRecover.setOnClickListener(this)


        toDefineToolbar()
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

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.button_recover -> {
                onBackPressed()
            }
        }
    }
}