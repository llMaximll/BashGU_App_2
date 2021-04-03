package com.github.llmaximll.bashgu_app.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.github.llmaximll.bashgu_app.R

class ProfileFragment : Fragment() {

    interface Callbacks {
        fun onProfileFragment()
    }

    private lateinit var toolBar: Toolbar
    private lateinit var recoveryTextView: TextView

    private var callbacks: Callbacks? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacks = context as Callbacks
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        toolBar = view.findViewById(R.id.tool_bar)
        recoveryTextView = view.findViewById(R.id.recovery_text_view)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolBar.title = getString(R.string.profile)
    }

    override fun onStart() {
        super.onStart()
        recoveryTextView.setOnClickListener {
            callbacks?.onProfileFragment()
        }
    }

    override fun onDetach() {
        super.onDetach()
        callbacks = null
    }

    companion object {
        fun newInstance(): ProfileFragment {
            return ProfileFragment()
        }
    }
}