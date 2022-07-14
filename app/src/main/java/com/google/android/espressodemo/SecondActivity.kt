package com.google.android.espressodemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.espressodemo.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSecondActivity.setOnClickListener {
            onBackPressed()
        }
    }
}