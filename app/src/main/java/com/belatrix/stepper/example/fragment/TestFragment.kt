package com.belatrix.stepper.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.fragment.app.Fragment

import com.belatrix.stepper.example.R

class TestFragment : Fragment() {

    private var position = 0

    lateinit var txvPage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments != null && arguments!!.containsKey(ARG_POSITION)) {
            position = arguments!!.getInt(ARG_POSITION)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_test, container, false)
        txvPage = view.findViewById(R.id.txv_page)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txvPage.text = "Fragmento $position"
    }

    companion object {

        private val ARG_POSITION = "ARG_POSITION"

        fun newInstance(position: Int): TestFragment {
            val fragment = TestFragment()
            val args = Bundle()
            args.putInt(ARG_POSITION, position)
            fragment.arguments = args
            return fragment
        }
    }

}