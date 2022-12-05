package com.example.tsp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.example.tsp.algorithm.Algorithm
import com.example.tsp.algorithm.Graph


class GraphCalculation(val graph: Graph) : Fragment() {

    lateinit var progressBar: ProgressBar
    lateinit var cancelButton: Button
    lateinit var estimatedTimeTextView: TextView

    lateinit var algorithm: Algorithm

    private fun initializeComponents(view: View){

        with(view){

            progressBar = findViewById(R.id.progressBar)
            cancelButton = findViewById(R.id.cancelButton)
            estimatedTimeTextView = findViewById(R.id.estimatedTimeTextView)

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        with(inflater.inflate(R.layout.fragment_graph_calculation, container, false)){

            initializeComponents(this)

            algorithm = Algorithm(graph)

            algorithm.updateEvent.on {
                progressBar.progress = it.progress.first/it.progress.second

            }
            algorithm.solve()





            return this
        }
    }

}