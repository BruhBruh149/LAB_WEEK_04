package com.example.lab_week_04

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

class ListFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Find all coffee items
        val affogatoView = view.findViewById<View>(R.id.affogato)
        val americanoView = view.findViewById<View>(R.id.americano)
        val latteView = view.findViewById<View>(R.id.latte)

        // Set click listeners for each coffee item
        affogatoView.setOnClickListener {
            navigateToDetail(it.id)
        }

        americanoView.setOnClickListener {
            navigateToDetail(it.id)
        }

        latteView.setOnClickListener {
            navigateToDetail(it.id)
        }
    }

    private fun navigateToDetail(coffeeId: Int) {
        val bundle = Bundle().apply {
            putInt(COFFEE_ID, coffeeId)
        }

        // Navigate to detail fragment
        view?.let {
            Navigation.findNavController(it).navigate(
                R.id.action_listFragment_to_detailFragment,
                bundle
            )
        }
    }

    companion object {
        const val COFFEE_ID = "COFFEE_ID"
    }
}