package com.sergey.studentprogressappmvvmclean.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sergey.studentprogressappmvvmclean.data.repository.StudentRepositoryImpl
import com.sergey.studentprogressappmvvmclean.data.storage.sharedrefs.SharedPrefStudentStorage
import com.sergey.studentprogressappmvvmclean.databinding.ActivityMainBinding
import com.sergey.studentprogressappmvvmclean.domain.models.Student
import com.sergey.studentprogressappmvvmclean.domain.usecase.AddStudentToStudentTableUseCase
import com.sergey.studentprogressappmvvmclean.domain.usecase.SaveStudentTableUseCase
import com.sergey.studentprogressappmvvmclean.domain.usecase.UploadStudentTableUseCase
import com.sergey.studentprogressappmvvmclean.presentation.Adapters.StudentAdapter

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding ?: throw IllegalStateException("Binding for ActivityMain must not be null")
    private var studentList = mutableListOf<com.sergey.studentprogressappmvvmclean.domain.models.Student>()

    //private val closeStudentEditPanelUseCase = CloseStudentEditPanelUseCase()
    private val adapter = StudentAdapter(studentList, this)
    private val addStudentToStudentTableUseCase =AddStudentToStudentTableUseCase(adapter)
    //private val openAddStudentPanelUseCase = OpenAddStudentPanelUseCase()
    private val sharedPrefStudentStorage = SharedPrefStudentStorage(this, null)
    private val studentRepositoryImpl = StudentRepositoryImpl(sharedPrefStudentStorage)
    private val saveStudentTableUseCase = SaveStudentTableUseCase(studentRepositoryImpl)
    private val uploadStudentTableUseCase = UploadStudentTableUseCase(adapter, studentRepositoryImpl)
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
        rvStudents.adapter = adapter

        bthAdd.setOnClickListener {
            if (llAddStudentPanel.visibility != View.VISIBLE) {
                llAddStudentPanel.visibility = View.VISIBLE
            }
            else
            {
                val fIO = binding.tvFIO.text.toString()
                val sinnKS1 = binding.SinnKS1.selectedItem.toString().toInt()
                val sinnKS2 = binding.SinnKS2.selectedItem.toString().toInt()
                val sinnKS3 = binding.SinnKS3.selectedItem.toString().toInt()
                val sinnKS4 = binding.SinnKS4.selectedItem.toString().toInt()
                val student = com.sergey.studentprogressappmvvmclean.domain.models.Student(
                    fIO,
                    sinnKS1,
                    sinnKS2,
                    sinnKS3,
                    sinnKS4
                )
                addStudentToStudentTableUseCase.exectute(student)
            }
        }
        bthCloseAddStudentPanel.setOnClickListener {
            llAddStudentPanel.visibility = View.GONE
        }
        bthDownload.setOnClickListener {
            uploadStudentTableUseCase.exectute()
        }
        bthSave.setOnClickListener {
            saveStudentTableUseCase.exectute(studentList)
        }
    }
}