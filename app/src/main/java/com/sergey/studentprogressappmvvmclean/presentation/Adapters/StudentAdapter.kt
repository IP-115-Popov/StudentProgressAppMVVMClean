package com.sergey.studentprogressappmvvmclean.presentation.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.sergey.studentprogressappmvvmclean.R
import com.sergey.studentprogressappmvvmclean.databinding.StudentItemBinding
import com.sergey.studentprogressappmvvmclean.domain.adapters.IStudentAdapter
import com.sergey.studentprogressappmvvmclean.domain.models.Student


class StudentAdapter(var items: MutableList<Student>, var context: Context) :
    RecyclerView.Adapter<StudentAdapter.MyViewHolder>(),
    IStudentAdapter
    {
    override fun addStudent(student: Student)
    {
        items.add(student)
        notifyDataSetChanged()
    }
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view)
    {
        val binding = StudentItemBinding.bind(view)
        val tvKSSubject1 = binding.tvKSSubject1
        val tvKSSubject2 = binding.tvKSSubject2
        val tvKSSubject3 = binding.tvKSSubject3
        val tvKSSubject4 = binding.tvKSSubject4
        val tvKSAverage  = binding.tvKSAverage
        val tvFIO = binding.tvFIO
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.student_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) = with(holder) {
        fun setSubjectColor(textView: TextView, value: Float) {
            val color = if (value < 1) R.color.red else R.color.lightGreen
            textView.setTextColor(ContextCompat.getColor(context, color))
        }
        with(holder) {
            val item = items[position]

            val subjectTextViews = arrayOf(tvKSSubject1, tvKSSubject2, tvKSSubject3, tvKSSubject4, tvKSAverage)
            val KSSubject = with(items[position])
            {
               arrayOf(
                    KSSubject1,
                    KSSubject2,
                    KSSubject3,
                    KSSubject4,
                    KSAverage
                )
            }

            for ((index, subject) in KSSubject.withIndex()) {
                subjectTextViews[index].text = subject.toString()
                setSubjectColor(subjectTextViews[index], subject.toFloat())
            }

            tvKSAverage.text = item.KSAverage.toString()
            setSubjectColor(tvKSAverage, item.KSAverage)

            tvFIO.text= item.FIO
        }
    }
}