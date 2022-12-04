package com.example.tsp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

data class City(val name: String, val lat: Double, val long:Double)

class GraphCreation : Fragment() {

    private lateinit var nameInput:TextInputEditText
    private lateinit var latInput:TextInputEditText
    private lateinit var longInput:TextInputEditText
    private lateinit var addButton :Button

    private var cities = mutableListOf<City>()

    private fun initializeComponents(view:View){

        with(view){
            nameInput = findViewById(R.id.nameInput)
            latInput = findViewById(R.id.latInput)
            longInput = findViewById(R.id.longInput)
            addButton = findViewById(R.id.addButton)
        }

    }

    private fun addCity(name:String, lat:Double,long:Double){

        cities.add(City(name,lat,long))

    }

    private fun parseErrorPopup(varName:String){
        //TODO: thsi ait workin for some reason
        // Im suspecting the context is fucked
        Toast.makeText(requireContext() ,"Invalid %s .".format(varName),Toast.LENGTH_LONG)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        with(inflater.inflate(R.layout.fragment_graph_creation, container, false)){

            initializeComponents(this)

            addButton.setOnClickListener {

                var lat = latInput.toString().toDoubleOrNull()
                if(lat == null){
                    parseErrorPopup("latitude")
                    return@setOnClickListener
                }
                var long = longInput.toString().toDoubleOrNull()
                if(long == null){
                    parseErrorPopup("longitude")
                    return@setOnClickListener
                }

                addCity(nameInput.text.toString(), lat, long)

            }

            return this
        }
    }
}