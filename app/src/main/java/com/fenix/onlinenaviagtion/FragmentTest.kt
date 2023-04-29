package com.fenix.onlinenaviagtion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.fenix.onlinenaviagtion.databinding.FragmentTestBinding
import com.proyekt.narodnieproyekt.models.Question


class FragmentTest : Fragment() {

   private var _binding:FragmentTestBinding?=null
    private val binding get() = _binding!!

    private lateinit var list: ArrayList<Question>
    private lateinit var listTxt: ArrayList<TextView>
    var position = 0
    var has = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentTestBinding.inflate(layoutInflater)
        list = ArrayList()
        listTxt = ArrayList()
        listTxt.add(binding.answer1)
        listTxt.add(binding.answer2)

        loadList()
        loadQuestion()

        binding.answer1.setOnClickListener {
            chekQuestion(1)
        }
        binding.answer2.setOnClickListener {
            chekQuestion(2)
        }
        binding.btnNext.setOnClickListener {
            if (has) {
                for (textView in listTxt) {
                    textView.setBackgroundResource(R.drawable.background_txt)
                }
                if (position + 1 != list.size) {
                    position++
                    loadQuestion()
                    has = false
                } else {
                    has = false
                    position = 0
                    loadQuestion()
                }
            }

        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun loadList() {
        list.add(Question("Инвестиции в производстве предполагают:",
            "а. Вложения на содержание машин и оборудования",
            "б. Вложения в виде капитальных затрат",
            2
        ))
        list.add(Question("Под инвестированием понимается:",
            "а. Целенаправленное вложение капитала на определенный срок",
            "б. Изучение «ниш» экономики для более выгодного вложения капитала",
            1
        ))
        list.add(Question("К портфельным иностранным инвестициям относятся:",
            "а. Вложения капитала, взятого на определенных условиях в любом иностранном банке",
            "б. Вложения в иностранные ценные бумаги, цель которого заключается в «игре» на курсах валют с целью получения прибыли",
            2
        ))
        list.add(Question("Законодательные условия инвестирования представляют собой:",
            "а. Условия, определяющие минимальную сумму инвестиций для разных групп инвесторов",
            "б. Нормативные условия, создающие законодательный фон, на котором осуществляется инвестиционная деятельности",
            2
        ))
        list.add(Question("Основная цель инвестиционного проекта:",
            "а. Создание взаимовыгодных условий сотрудничества между бизнес-партнерами",
            "б. Получение максимально возможной прибыли",
            2
        ))
    }

    private fun loadQuestion() {
        binding.txtQuestion.text = list[position].question
        binding.answer1.text = list[position].answer1
        binding.answer2.text = list[position].answer2
    }

    private fun chekQuestion(answer: Int) {
        if (!has) {
            if (answer == list[position].correctAnswer) {
                listTxt[answer - 1].setBackgroundResource(R.drawable.background_txt_correct)

                loadQuestion()
            } else {
                listTxt[list[position].correctAnswer - 1].setBackgroundResource(R.drawable.background_txt_correct)
                listTxt[answer - 1].setBackgroundResource(R.drawable.background_txt_wrong)

            }

            has = true

        }

    }

}