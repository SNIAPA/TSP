package com.example.tsp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class GraphResult : Fragment() {

    companion object {
        var ans : Pair<List<Int>,Double>? = null
    }

    lateinit var ansTextView : TextView
    lateinit var backButton : Button

    private fun initializeComponents(view: View){

        with(view){

            ansTextView = findViewById(R.id.ansTextView)
            backButton = findViewById(R.id.backButton)


            backButton.setOnClickListener {

                parentFragmentManager.beginTransaction().replace(R.id.fragmentContainer,GraphCreation()).commit()

            }


        }



    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        with(inflater.inflate(R.layout.fragment_graph_result, container, false)){

            initializeComponents(this)


            ansTextView.text = ans.toString()

            return this
        }





    }

}