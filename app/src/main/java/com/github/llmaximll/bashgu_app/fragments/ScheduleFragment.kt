package com.github.llmaximll.bashgu_app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.github.llmaximll.bashgu_app.R

class ScheduleFragment : Fragment() {

    private lateinit var toolBar: Toolbar
    private lateinit var facultySpinner: Spinner
    private lateinit var groupSpinner: Spinner

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_schedule, container, false)

        toolBar = view.findViewById(R.id.tool_bar)
        facultySpinner = view.findViewById(R.id.faculty_spinner)
        groupSpinner = view.findViewById(R.id.group_spinner)

        val facultiesList = listOf(
                "Факультеты", "филологический", "исторический", "экономический", "юридический", "естественнонаучный", "факультет математики",
                "факультет информационных технологий", "факультет педагогики", "факультет психологии", "факультет башкирской филологии",
                "факультет тюркской филологии"
        )

        val facultySpinnerAdapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_dropdown_item,
                facultiesList
        )

        facultySpinner.adapter = facultySpinnerAdapter

        val groupsList = listOf(
                "Группа 1", "Группа 2", "Группа 3"
        )

        val groupSpinnerAdapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_dropdown_item,
                groupsList
        )

        groupSpinner.adapter = groupSpinnerAdapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolBar.title = getString(R.string.schedule)
    }

    companion object {
        fun newInstance(): ScheduleFragment {
            return ScheduleFragment()
        }
    }
}