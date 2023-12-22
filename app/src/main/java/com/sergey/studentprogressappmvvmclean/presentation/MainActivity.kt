package com.sergey.studentprogressappmvvmclean.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sergey.studentprogressappmvvmclean.databinding.ActivityMainBinding
import com.sergey.studentprogressappmvvmclean.domain.models.Student
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding ?: throw IllegalStateException("Binding for ActivityMain must not be null")

    private val vm: MainViewModel by viewModel<MainViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val llAddStudentPanel: LinearLayout = binding.llAddStudentPonel
        val rvStudents: RecyclerView = binding.rvStudents

        val bthAdd = binding.bthAdd
        val bthCloseAddStudentPanel = binding.bthCloseAddStudentPonel
        val bthDownload = binding.bthDownload
        val bthSave = binding.bthSave

        rvStudents.layoutManager =  LinearLayoutManager(this)
        rvStudents.adapter = vm.getAdapter()

        vm.resultLive.observe(this)
        {
            llAddStudentPanel.visibility = it
        }

        bthAdd.setOnClickListener {
            if (llAddStudentPanel.visibility != View.VISIBLE) {
                vm.openAddStudentPanel(View.VISIBLE)
            }
            else
            {
                val fIO = binding.tvFIO.text.toString()
                val sinnKS1 = binding.SinnKS1.selectedItem.toString().toInt()
                val sinnKS2 = binding.SinnKS2.selectedItem.toString().toInt()
                val sinnKS3 = binding.SinnKS3.selectedItem.toString().toInt()
                val sinnKS4 = binding.SinnKS4.selectedItem.toString().toInt()
                val student = Student(
                    fIO,
                    sinnKS1,
                    sinnKS2,
                    sinnKS3,
                    sinnKS4
                )
               vm.Add(student)
            }
        }
        bthCloseAddStudentPanel.setOnClickListener {
            vm.closeStudentEditPanel(View.GONE)
        }
        bthDownload.setOnClickListener {
            vm.Download()
        }
        bthSave.setOnClickListener {
            vm.Save()
        }
    }
}