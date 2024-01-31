package com.example.netclanexplorer

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton

class home : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val personalfrag = personal()
        val refinebut = view.findViewById<ImageButton>(R.id.imageButton2)
        refinebut.setOnClickListener(){
            val intu = Intent(context, refineact::class.java)
            startActivity(intu)
        }
        openFragment(personalfrag)
    }
    private fun openFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(R.id.frameLayoutss, fragment)
            .addToBackStack(null)
            .commit()
    }

}