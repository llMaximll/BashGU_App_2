package com.github.llmaximll.bashgu_app.fragments

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.llmaximll.bashgu_app.R

private const val TAG = "InformationFragment"

class InformationFragment : Fragment() {

    private lateinit var toolBar: Toolbar
    private lateinit var recyclerView: RecyclerView

    private var adapter: DocAdapter? = DocAdapter(listOf())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_information, container, false)

        toolBar = view.findViewById(R.id.tool_bar)
        recyclerView = view.findViewById(R.id.recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val docList = listOf(getString(R.string.license), getString(R.string.application_form_for_admission),
                getString(R.string.application_form_for_deduction), getString(R.string.installment_payment_form),
                getString(R.string.increased_state_academic_scholarship),
                getString(R.string.social_scholarship), getString(R.string.financial_assistance))
        updateUI(docList)
        toolBar.title = getString(R.string.information)
    }

    private fun updateUI(docList: List<String>) {
        Log.i(TAG, "docList = $docList")
        adapter = DocAdapter(docList)
        recyclerView.adapter = adapter
    }

    private inner class DocHolder(view: View)
        : RecyclerView.ViewHolder(view) {

        private val docTextView: TextView = itemView.findViewById(R.id.doc_text_view)

        fun bind(docString: String) {
            docTextView.movementMethod = LinkMovementMethod.getInstance()
            docTextView.text = docString
        }
    }

    private inner class DocAdapter(val docList: List<String>)
        : RecyclerView.Adapter<DocHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DocHolder {
            val view = layoutInflater.inflate(R.layout.item_doc_list, parent, false)
            return DocHolder(view)
        }

        override fun onBindViewHolder(holder: DocHolder, position: Int) {
            val docString = docList[position]
            holder.bind(docString)
        }

        override fun getItemCount(): Int = docList.size
    }

    companion object {
        fun newInstance(): InformationFragment {
            return InformationFragment()
        }
    }
}