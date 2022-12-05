package com.example.tsp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.fragment.app.FragmentContainerView
import com.example.tsp.algorithm.Algorithm
import com.example.tsp.algorithm.Graph

const val CITY_LIMIT = 8

class MainActivity : AppCompatActivity() {

    lateinit var fragmentContainer: FragmentContainerView

    private fun initializeComponents(){

        fragmentContainer = findViewById(R.id.fragmentContainer)

    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeComponents()


        Log.d("source id",fragmentContainer.id.toString())

    }
}