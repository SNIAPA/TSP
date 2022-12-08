package com.example.tsp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class GraphResult : Fragment() {

    companion object {
        var ans : Pair<List<Int>,Double>? = null
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {




        return inflater.inflate(R.layout.fragment_graph_result, container, false)
    }

}