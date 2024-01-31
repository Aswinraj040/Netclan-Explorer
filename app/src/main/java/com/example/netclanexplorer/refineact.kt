package com.example.netclanexplorer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.RelativeLayout
import android.widget.SeekBar
import android.widget.Spinner
import android.widget.TextView
import androidx.core.content.ContextCompat

class refineact : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_refineact)
        val slider = findViewById<SeekBar>(R.id.slider)
        val valueDisplay = findViewById<TextView>(R.id.valueDisplay)
        try {
            this.supportActionBar!!.hide()
        } // catch block to handle NullPointerException
        catch (e: NullPointerException) {
        }
        window.statusBarColor = ContextCompat.getColor(this, R.color.best)
        val spinner = findViewById<Spinner>(R.id.spinner)


        // Create an array of items
        val items = arrayOf("Available | Hey Let us Connect", "Away | Stay Discrete And Watch", "Busy | Do Not Disturb | Will Catch Up Lat..", "SOS | Emergency! Need Assistance! HEL.. ")
        // Create an ArrayAdapter using the string array and a default spinner layout
        val adapter = ArrayAdapter(this@refineact, android.R.layout.simple_spinner_item, items)

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Apply the adapter to the Spinner
        spinner.adapter = adapter

        // Set a listener to handle item selection
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItem = items[position]
                // Do something with the selected item
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle the case where nothing is selected
            }
        }
        val go = findViewById<ImageButton>(R.id.goback)
        go.setOnClickListener(){
            val intu = Intent(this , MainActivity::class.java)
            startActivity(intu)
            finish()
        }
        // Set the SeekBar's maximum value (e.g., 100)
        slider.max = 100

        // Handle the SeekBar value changes
        slider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                valueDisplay.text = progress.toString()

                // Calculate the position of the TextView based on progress
                val seekBarWidth = seekBar.width
                val thumbOffset = (progress * seekBarWidth / seekBar.max).toFloat()

                // Update the position of the TextView
                val layoutParams = valueDisplay.layoutParams as RelativeLayout.LayoutParams
                layoutParams.leftMargin = thumbOffset.toInt() - valueDisplay.width / 2
                valueDisplay.layoutParams = layoutParams
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Handle touch start event
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Handle touch end event
            }
        })
    }
}