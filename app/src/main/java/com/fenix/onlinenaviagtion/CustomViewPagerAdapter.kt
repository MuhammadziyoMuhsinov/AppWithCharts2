package com.fenix.onlinenaviagtion


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class CustomViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {

        when(position){
            0->{
                return FragmentDiagram1()
            }
            1->{
                return FragmentDiagram2()
            }
            2->{
                return FragmentTest()
            }
            3->{
                return FragmentAboutUs()
            }
//            4->{
//                return FragmentShare()
//            }
            else->{
                return FragmentDiagram1()
            }

        }

    }
}