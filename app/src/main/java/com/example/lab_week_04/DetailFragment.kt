package com.example.lab_week_04

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Find views by their correct IDs
        val coffeeTitle = view.findViewById<TextView>(R.id.coffee_title)
        val coffeeDesc = view.findViewById<TextView>(R.id.coffee_desc)

        // Get coffee ID from arguments
        val coffeeId = arguments?.getInt(COFFEE_ID, 0) ?: 0

        // Set coffee data based on ID
        setCoffeeData(coffeeId, coffeeTitle, coffeeDesc)
    }

    private fun setCoffeeData(id: Int, titleView: TextView, descView: TextView) {
        when (id) {
            R.id.affogato -> {
                titleView.text = getString(R.string.affogato_title)
                descView.text = getString(R.string.affogato_desc)
            }
            R.id.americano -> {
                titleView.text = getString(R.string.americano_title)
                descView.text = getString(R.string.americano_desc)
            }
            R.id.latte -> {
                titleView.text = getString(R.string.latte_title)
                descView.text = getString(R.string.latte_desc)
            }
            else -> {
                titleView.text = "Coffee Not Found"
                descView.text = "Description not available"
            }
        }
    }

    companion object {
        const val COFFEE_ID = "COFFEE_ID"
    }
}