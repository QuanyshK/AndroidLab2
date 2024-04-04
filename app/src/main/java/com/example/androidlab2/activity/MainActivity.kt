package com.example.androidlab2.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidlab2.R
import com.example.androidlab2.databinding.ActivityMainBinding
import com.example.androidlab2.fragment.CatListFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container_view, CatListFragment.newInstance())
                .commit()

    }
}