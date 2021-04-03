package com.github.llmaximll.bashgu_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.github.llmaximll.bashgu_app.fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(),
        ProfileFragment.Callbacks {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setBottomNavigationView()

        val currentFragment = supportFragmentManager
            .findFragmentById(R.id.container_fragment)

        if (currentFragment == null) {
            val fragment = InformationFragment.newInstance()
            supportFragmentManager.commit {
                add(R.id.container_fragment, fragment)
            }
        }
    }

    private fun setBottomNavigationView() {
        bottomNavigationView = findViewById(R.id.bottom_navigation_view)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.information -> {
                    val fragment = InformationFragment.newInstance()
                    supportFragmentManager.commit {
                        replace(R.id.container_fragment, fragment)
                    }
                }
                R.id.schedule -> {
                    val fragment = ScheduleFragment.newInstance()
                    supportFragmentManager.commit {
                        replace(R.id.container_fragment, fragment)
                    }
                }
                R.id.news -> {
                    val fragment = NewsFragment.newInstance()
                    supportFragmentManager.commit {
                        replace(R.id.container_fragment, fragment)
                    }
                }
                R.id.profile -> {
                    val fragment = ProfileFragment.newInstance()
                    supportFragmentManager.commit {
                        replace(R.id.container_fragment, fragment)
                    }
                }
            }
            true
        }
    }

    override fun onProfileFragment() {
        val fragment = RecoveryAccountFragment.newInstance()
        supportFragmentManager.commit {
            replace(R.id.container_fragment, fragment)
            addToBackStack(null)
        }
    }
}