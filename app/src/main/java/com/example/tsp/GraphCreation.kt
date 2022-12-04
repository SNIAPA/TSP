package com.example.tsp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

data class City(val name: String, val lat: Double, val long:Double)

class GraphCreation : Fragment() {

    private lateinit var nameInput: TextInputEditText
    private lateinit var latInput: TextInputEditText
    private lateinit var longInput: TextInputEditText
    private lateinit var addButton: Button
    private lateinit var randomizeButton: Button
    private lateinit var calculatePathButton: Button
    private lateinit var cityTable: TableLayout

    private var cities = mutableListOf<City>()

    private fun initializeComponents(view:View){

        with(view){
            nameInput = findViewById(R.id.nameInput)
            latInput = findViewById(R.id.latInput)
            longInput = findViewById(R.id.longInput)
            addButton = findViewById(R.id.addButton)
            randomizeButton = findViewById(R.id.randomizeButton)
            calculatePathButton = findViewById(R.id.calculatePathButton)
            cityTable = findViewById(R.id.cityTable)
        }

    }

    private fun addCity(name:String, lat:Double,long:Double){

        cities.add(City(name,lat,long))


        val cityRow = TableRow(context)
        cityRow.addView(TextView(context).apply { text = name;gravity=1 })
        cityRow.addView(TextView(context).apply { text = lat.toString();gravity=1 })
        cityRow.addView(TextView(context).apply { text = long.toString();gravity=1 })

        this.cityTable.addView(cityRow)
    }

    private fun errorPopup(message:String){
        //TODO: this aint workin for some reason
        // Im suspecting the context is fucked
        Toast.makeText(requireContext() ,message,Toast.LENGTH_LONG)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        with(inflater.inflate(R.layout.fragment_graph_creation, container, false)){

            initializeComponents(this)

            addButton.setOnClickListener {

                if(cities.size >= CITY_LIMIT){
                    errorPopup("City limit is %s".format(CITY_LIMIT))
                    return@setOnClickListener
                }

                val name = nameInput.text.toString()
                if(name.isEmpty()){
                    errorPopup("Invalid name")
                    return@setOnClickListener
                }

                val lat = latInput.text.toString().toDoubleOrNull()
                if(lat == null){
                    errorPopup("Invalid latitude")
                    return@setOnClickListener
                }
                val long = longInput.text.toString().toDoubleOrNull()
                if(long == null){
                    errorPopup("Invalid longitude")
                    return@setOnClickListener
                }

                addCity(nameInput.text.toString(), lat, long)

            }

            return this
        }
    }
}