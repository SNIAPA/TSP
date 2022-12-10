package com.example.tsp

import android.graphics.Bitmap
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.view.drawToBitmap
import androidx.fragment.app.Fragment
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*

class GraphResult : Fragment() {

    companion object {
        var ans : Pair<List<Int>,Double>? = null
    }

    lateinit var ansTextView : TextView
    lateinit var backButton : Button
    lateinit var saveButton : Button

    private fun initializeComponents(view: View){

        with(view){

            ansTextView = findViewById(R.id.ansTextView)
            backButton = findViewById(R.id.backButton)
            saveButton = findViewById(R.id.saveButton)


            backButton.setOnClickListener {

                parentFragmentManager.beginTransaction().replace(R.id.fragmentContainer,GraphCreation()).commit()

            }

            saveButton.setOnClickListener {

                val bitmap = requireActivity().window.decorView.rootView.drawToBitmap()

                val sdf = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault())
                val date: String = sdf.format(Date())

                MediaStore.Images.Media.insertImage(context.getContentResolver(), bitmap, date+".jpg" , "");

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