package com.example.tsp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tsp.algorithm.Graph


class GraphCalculation(val graph: Graph) : Fragment() {

    private fun initializeComponents(view: View){

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        with(inflater.inflate(R.layout.fragment_graph_calculation, container, false)){

            initializeComponents(this)



            return this
        }
    }

}