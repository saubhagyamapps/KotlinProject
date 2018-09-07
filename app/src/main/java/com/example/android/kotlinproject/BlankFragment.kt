package com.example.android.kotlinproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_blank.view.*

class BlankFragment : Fragment() {

    companion object {
        fun newInstance() = BlankFragment()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_blank, container, false)
        val sharedPreferences = activity?.getSharedPreferences("data", Context.MODE_PRIVATE)
        view.txtNameF.text = sharedPreferences?.getString("email", "")
        view.txtNameF.setOnClickListener {
            startActivity(Intent(activity, LoginActivity::class.java))
        }
        return view;

    }
}
