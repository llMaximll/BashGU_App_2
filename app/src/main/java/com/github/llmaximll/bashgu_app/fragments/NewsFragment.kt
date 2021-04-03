package com.github.llmaximll.bashgu_app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.github.llmaximll.bashgu_app.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class NewsFragment : Fragment() {

    private lateinit var toolBar: Toolbar
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news, container, false)

        toolBar = view.findViewById(R.id.tool_bar)
        viewPager = view.findViewById(R.id.view_pager)
        tabLayout = view.findViewById(R.id.tab_layout)

        viewPager.adapter = PagerAdapter()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolBar.title = getString(R.string.news)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Новости"
                1 -> tab.text = "Приглашения"
                2 -> tab.text = "Опросы и голосования"
            }
            viewPager.setCurrentItem(tab.position, true)
        }.attach()
    }

    private inner class PagerViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {


    }

    private inner class PagerAdapter : RecyclerView.Adapter<PagerViewHolder>() {

        var count = 0

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
            var view: View? = null
            when (count) {
                0 -> {
                    view = layoutInflater.inflate(R.layout.item_news, parent, false)
                }
                1 -> {
                    view = layoutInflater.inflate(R.layout.item_invitations, parent, false)
                }
                2 -> {
                    view = layoutInflater.inflate(R.layout.item_surveys, parent, false)
                }
            }
            count++
            return PagerViewHolder(view!!)
        }

        override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {

        }

        override fun getItemCount(): Int = 3
    }

    companion object {
        fun newInstance(): NewsFragment {
            return NewsFragment()
        }
    }
}