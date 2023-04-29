package com.fenix.onlinenaviagtion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.fenix.onlinenaviagtion.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlin.math.abs
import kotlin.math.max

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val customViewPagerAdapter = CustomViewPagerAdapter(this)
        binding.myViewPager.adapter = customViewPagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.myViewPager)
        { tab, position ->
            when(position){
                0->{tab.text = "диаграм"
                    tab.setIcon(R.drawable.ic_diagram1)
                }
                1->{tab.text = "диаграм2"
                    tab.setIcon(R.drawable.ic_diagram_3)
                }
                2->{tab.text = "тест"
                    tab.setIcon(R.drawable.ic_test)
                }
                3->{tab.text = "информация"
                    tab.setIcon(R.drawable.ic_info1)
                }
                4->{tab.text = "поделиться"
                    tab.setIcon(R.drawable.ic_share)
                }
            }




        }.attach()

        binding.myViewPager.apply {
            setPageTransformer { page, position ->

                page.apply {
                    translationY = position * 500
                }

            }
        }
        binding.btnStart.setOnClickListener {
            binding.linearStart.visibility = View.GONE
        }

    }
}