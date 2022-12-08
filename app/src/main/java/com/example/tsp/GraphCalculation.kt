package com.example.tsp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.example.tsp.algorithm.Algorithm
import com.example.tsp.algorithm.Graph
import com.example.tsp.utils.UpdateEvent
import com.example.tsp.utils.UpdateEventData


class GraphCalculation : Fragment() {

    companion object {
        lateinit var graph: Graph
    }

    lateinit var progressBar: ProgressBar
    lateinit var cancelButton: Button
    lateinit var nextButton: Button

    lateinit var algorithm: Algorithm

    private fun initializeComponents(view: View){

        with(view){

            progressBar = findViewById(R.id.progressBar)
            cancelButton = findViewById(R.id.cancelButton)
            nextButton = findViewById(R.id.nextButton)

        }

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        with(inflater.inflate(R.layout.fragment_graph_calculation, container, false)){

            initializeComponents(this)

            cancelButton.setOnClickListener {
                parentFragmentManager.beginTransaction().replace(R.id.fragmentContainer,GraphCreation()).commit()

            }


            algorithm = Algorithm(GraphCalculation.graph)


            algorithm.updateEvent.on {
                progressBar.progress = (it.progress.toDouble()/algorithm.permutationCount.toDouble() * progressBar.max.toDouble()).toInt()
            }

            (Thread{
                val ans = algorithm.solve()
                activity?.runOnUiThread {
                    nextButton.isEnabled = true

                    nextButton.setOnClickListener {
                        GraphResult.ans = ans
                        parentFragmentManager.beginTransaction().replace(R.id.fragmentContainer,GraphResult()).commit()
                    }

                }
            }).start()





            return this
        }
    }

}