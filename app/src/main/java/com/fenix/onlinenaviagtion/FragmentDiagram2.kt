package com.fenix.onlinenaviagtion

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fenix.onlinenaviagtion.databinding.FragmentDiagram2Binding
import com.fenix.onlinenaviagtion.databinding.ItemListBinding
import com.fenix.onlinenaviagtion.models.Danniy
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate


class FragmentDiagram2 : Fragment() {

    private  var _binding:FragmentDiagram2Binding?=null
    private val binding get() = _binding!!
    private var position = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentDiagram2Binding.inflate(layoutInflater)

        val pieChart: PieChart = binding.pieChart
        val entries: ArrayList<PieEntry> = ArrayList()
        entries.add(PieEntry( 1052f))
        entries.add(PieEntry(1340f))
        entries.add(PieEntry(1564.0f))
        entries.add(PieEntry(1564f))
        entries.add(PieEntry(1683.1f))
        entries.add(PieEntry(1793f))
        entries.add(PieEntry(1879f))
        entries.add(PieEntry( 1856f))
        entries.add(PieEntry( 1483f))
        entries.add(PieEntry( 1438f))
        entries.add(PieEntry( 1287f))
        entries.add(PieEntry(  1359f))
        entries.add(PieEntry( 1268f))
        entries.add(PieEntry( 773f))
        entries.add(PieEntry( 713f))
        entries.add(PieEntry( 687f))
        entries.add(PieEntry( 691f))
        entries.add(PieEntry( 701f))

        val pieDataSet = PieDataSet(entries,"Entries")
        pieDataSet.setColors(ColorTemplate.LIBERTY_COLORS,200)
        pieDataSet.valueTextColor = Color.BLACK
        pieDataSet.valueTextSize = 10f
        val pieData = PieData(pieDataSet)
        pieChart.data = pieData
        pieChart.description.isEnabled = false
        pieChart.centerText = "2022 - 773"
        pieChart.animate()

        setList()
        setDannie()

        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun setList(): ArrayList<Danniy> {
        val list = ArrayList<Danniy>()
        list.add(Danniy("25.02.2022", "1017,32", R.drawable.blue1))
        list.add(Danniy("31.01.2022", "262,72", R.drawable.blue2))
        list.add(Danniy("30.12.2021", "1332,44", R.drawable.blue3))
        list.add(Danniy("30.11.2021", "665,1", R.drawable.blue4))
        list.add(Danniy("29.10.2021","1 388,64",R.drawable.blue5))
        list.add(Danniy("30.09.2021","1 373,58",R.drawable.blue1))
        list.add(Danniy("31.08.2021","1 419,39",R.drawable.blue2))
        list.add(Danniy("30.07.2021","1 379,10",R.drawable.blue3))
        list.add(Danniy("31.12.2020","1409,84",R.drawable.blue4))
        list.add(Danniy("30.11.2020","1388,54",R.drawable.blue5))
        list.add(Danniy("30.10.2020","1 341,82",R.drawable.blue1))
        list.add(Danniy("30.09.2020","1 368,12",R.drawable.blue2))
        list.add(Danniy("31.12.2019","1190,78",R.drawable.blue3))
        list.add(Danniy("29.11.2019","1 130,08",R.drawable.blue4))
        list.add(Danniy("31.10.2019","1 098,71",R.drawable.blue5))
        list.add(Danniy("30.09.2019","1 122,21",R.drawable.blue1))
        list.add(Danniy("30.08.2019","1 103,87",R.drawable.blue2))





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