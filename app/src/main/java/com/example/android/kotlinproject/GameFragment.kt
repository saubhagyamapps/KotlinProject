package com.example.android.kotlinproject

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_blank_fragment2.view.*


class GameFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_blank_fragment2, container, false)
        activity?.title = "Game"

        view.txtHelloword.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.framelaout_view, HomeFragment())?.commit()
            /* val myFragment = HomeFragment()
             val fragmentTransaction = fragmentManager?.beginTransaction()
             fragmentTransaction?.add(R.id.framelaout_view, myFragment, tag)
             fragmentTransaction?.addToBackStack(tag)
             fragmentTransaction?.commit()*/
        }

        return view
    }
}
