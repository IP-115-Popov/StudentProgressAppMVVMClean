package com.sergey.studentprogressappmvvmclean.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sergey.studentprogressappmvvmclean.R
import com.sergey.studentprogressappmvvmclean.databinding.ActivityMainBinding
import com.sergey.studentprogressappmvvmclean.domain.usecase.CloseStudentEditPanelUseCase

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding ?: throw IllegalStateException("Binding for ActivityMain must not be null")
    private val closeStudentEditPanelUseCase = CloseStudentEditPanelUseCase()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val llAddStudentPonel: LinearLayout = binding.llAddStudentPonel

        val bthAdd = binding.bthAdd
        val bthCloseAddStudentPonel = binding.bthCloseAddStudentPonel
        val bthDownload = binding.bthDownload
        val bthSave = binding.bthSave
        bthAdd.setOnClickListener {

        }
        bthCloseAddStudentPonel.setOnClickListener {
            closeStudentEditPanelUseCase.exectute(llAddStudentPonel)
        }
        bthDownload.setOnClickListener {

        }
        bthSave.setOnClickListener {

        }
    }
}