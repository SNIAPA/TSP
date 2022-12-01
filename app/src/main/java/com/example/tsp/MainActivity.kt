package com.example.tsp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var graph = Graph()
        var algo = Algorithm(graph)
        var path = algo.solve()
        Log.d("ans",path.toString())


    }
}