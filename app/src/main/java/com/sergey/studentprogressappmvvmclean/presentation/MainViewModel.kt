package com.sergey.studentprogressappmvvmclean.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sergey.studentprogressappmvvmclean.domain.models.Student
import com.sergey.studentprogressappmvvmclean.domain.usecase.AddStudentToStudentTableUseCase
import com.sergey.studentprogressappmvvmclean.domain.usecase.CloseStudentEditPanelUseCase
import com.sergey.studentprogressappmvvmclean.domain.usecase.OpenAddStudentPanelUseCase
import com.sergey.studentprogressappmvvmclean.domain.usecase.SaveStudentTableUseCase
import com.sergey.studentprogressappmvvmclean.domain.usecase.UploadStudentTableUseCase
import com.sergey.studentprogressappmvvmclean.presentation.Adapters.StudentAdapter

class MainViewModel(
    private val closeStudentEditPanelUseCase :CloseStudentEditPanelUseCase,
    private val addStudentToStudentTableUseCase :AddStudentToStudentTableUseCase,
    private val openAddStudentPanelUseCase :OpenAddStudentPanelUseCase,
    private val saveStudentTableUseCase :SaveStudentTableUseCase,
    private val uploadStudentTableUseCase :UploadStudentTableUseCase,
    private val adapter : StudentAdapter,
    private val studentList: MutableList<Student>
) : ViewModel() {
    private val resultLiveMutable = MutableLiveData<Int>()
    val resultLive: LiveData<Int> = resultLiveMutable
    fun closeStudentEditPanel(param: Int){
        resultLiveMutable.value = param
    }
    fun openAddStudentPanel(param: Int)
    {
        resultLiveMutable.value = param
    }
    fun getAdapter(): StudentAdapter {
        return adapter
    }
    fun Add(student : Student) {
        addStudentToStudentTableUseCase.exectute(student)
    }
    fun Download() {
        uploadStudentTableUseCase.exectute()
    }
    fun Save() {
        saveStudentTableUseCase.exectute(studentList)
    }
}