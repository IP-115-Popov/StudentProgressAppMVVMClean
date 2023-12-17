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
import com.sergey.studentprogressappmvvmclean.domain.usecase.CloseStudentEditPanelUseCase
import com.sergey.studentprogressappmvvmclean.domain.usecase.OpenAddStudentPanelUseCase
import com.sergey.studentprogressappmvvmclean.domain.usecase.SaveStudentTableUseCase
import com.sergey.studentprogressappmvvmclean.domain.usecase.UploadStudentTableUseCase
import com.sergey.studentprogressappmvvmclean.presentation.Adapters.StudentAdapter

class MainActivity : AppCompatActivity() {
    var studentList = mutableListOf<Student>()
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding ?: throw IllegalStateException("Binding for ActivityMain must not be null")
    private val closeStudentEditPanelUseCase = CloseStudentEditPanelUseCase()
    val adapter = StudentAdapter(studentList, this)
    private val addStudentToStudentTableUseCase =  AddStudentToStudentTableUseCase(adapter)
    private val openAddStudentPanelUseCase = OpenAddStudentPanelUseCase()
    private val sharedPrefStudentStorage = SharedPrefStudentStorage(this, null)
    private val studentRepositoryImpl = StudentRepositoryImpl(sharedPrefStudentStorage)
    private val saveStudentTableUseCase = SaveStudentTableUseCase(studentRepositoryImpl)
    private val uploadStudentTableUseCase = UploadStudentTableUseCase(adapter, studentRepositoryImpl)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val llAddStudentPonel: LinearLayout = binding.llAddStudentPonel
        val rvStudents: RecyclerView = binding.rvStudents

        val bthAdd = binding.bthAdd
        val bthCloseAddStudentPonel = binding.bthCloseAddStudentPonel
        val bthDownload = binding.bthDownload
        val bthSave = binding.bthSave

        rvStudents.layoutManager =  LinearLayoutManager(this)
        rvStudents.adapter = adapter

        bthAdd.setOnClickListener {
            if (llAddStudentPonel.visibility != View.VISIBLE) {
                openAddStudentPanelUseCase.exectute(llAddStudentPonel)
            }
            else
            {
                val FIO = binding.tvFIO.text.toString()
                val SinnKS1 = binding.SinnKS1.selectedItem.toString().toInt()
                val SinnKS2 = binding.SinnKS2.selectedItem.toString().toInt()
                val SinnKS3 = binding.SinnKS3.selectedItem.toString().toInt()
                val SinnKS4 = binding.SinnKS4.selectedItem.toString().toInt()
                val student = Student(FIO, SinnKS1,SinnKS2,SinnKS3,SinnKS4)
                addStudentToStudentTableUseCase.exectute(student)
            }
        }
        bthCloseAddStudentPonel.setOnClickListener {
            closeStudentEditPanelUseCase.exectute(llAddStudentPonel)
        }
        bthDownload.setOnClickListener {
            uploadStudentTableUseCase.exectute()
        }
        bthSave.setOnClickListener {
            saveStudentTableUseCase.exectute(studentList)
        }
    }
}