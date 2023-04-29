package com.fenix.onlinenaviagtion

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fenix.onlinenaviagtion.databinding.FragmentDiagram1Binding
import com.fenix.onlinenaviagtion.databinding.ItemListBinding
import com.fenix.onlinenaviagtion.models.Danniy
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate


class FragmentDiagram1 :Fragment() {

    private var _binding: FragmentDiagram1Binding?=null
    private val binding get() = _binding!!

    private var position = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDiagram1Binding.inflate(layoutInflater)

        setDannie()
        val barChart: BarChart = binding.barChart
        val entries: ArrayList<BarEntry> = ArrayList()

        entries.add(BarEntry(2019f, 773f))
        entries.add(BarEntry(2020f, 1483f))
        entries.add(BarEntry(2021f, 1564f))
        entries.add(BarEntry(2022f, 1052f))



        val barDataSet = BarDataSet(entries, "Entries")
        barDataSet.setColors(ColorTemplate.LIBERTY_COLORS, 200)
        barDataSet.valueTextColor = Color.BLACK
        barDataSet.valueTextSize = 16f

        val barData = BarData(barDataSet)
        barChart.setFitBars(true)
        barChart.data = barData
        barChart.description.text = "Custom Bar Chart Example"

        barChart.animate()





        return binding.root

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    fun setList(): ArrayList<Danniy> {
        val list = ArrayList<Danniy>()
        list.add(Danniy("2022г", "1 017,32", R.drawable.blue1))
        list.add(Danniy("2021г", "1 332,44", R.drawable.blue2))
        list.add(Danniy("2020г", "1 409,84", R.drawable.blue3))
        list.add(Danniy("2019", "1 190,78", R.drawable.blue4))



        return list
    }

    fun setDannie() {
        val list = setList()
        list.forEach {
            val view = ItemListBinding.inflate(layoutInflater)
            view.data.text = list[position].data
            view.summa.text = list[position].summa1
            view.input.setImageResource(list[position].color!!)
            binding.listContainer.addView(view.root)
            position += 1
        }
    }

}