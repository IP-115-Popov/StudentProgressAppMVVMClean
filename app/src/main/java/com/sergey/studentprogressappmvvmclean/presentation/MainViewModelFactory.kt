package com.sergey.studentprogressappmvvmclean.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sergey.studentprogressappmvvmclean.data.repository.StudentRepositoryImpl
import com.sergey.studentprogressappmvvmclean.data.storage.sharedrefs.SharedPrefStudentStorage
import com.sergey.studentprogressappmvvmclean.domain.models.Student
import com.sergey.studentprogressappmvvmclean.domain.usecase.AddStudentToStudentTableUseCase
import com.sergey.studentprogressappmvvmclean.domain.usecase.CloseStudentEditPanelUseCase
import com.sergey.studentprogressappmvvmclean.domain.usecase.OpenAddStudentPanelUseCase
import com.sergey.studentprogressappmvvmclean.domain.usecase.SaveStudentTableUseCase
import com.sergey.studentprogressappmvvmclean.domain.usecase.UploadStudentTableUseCase
import com.sergey.studentprogressappmvvmclean.presentation.Adapters.StudentAdapter

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {
    private var studentList = mutableListOf<Student>()
    private val adapter = StudentAdapter(studentList, context)

    private val sharedPrefStudentStorage = SharedPrefStudentStorage(context, null)
    private val studentRepositoryImpl = StudentRepositoryImpl(sharedPrefStudentStorage)

    private val closeStudentEditPanelUseCase = CloseStudentEditPanelUseCase()
    private val addStudentToStudentTableUseCase = AddStudentToStudentTableUseCase(adapter)
    private val openAddStudentPanelUseCase = OpenAddStudentPanelUseCase()
    private val saveStudentTableUseCase = SaveStudentTableUseCase(studentRepositoryImpl)
    private val uploadStudentTableUseCase = UploadStudentTableUseCase(adapter, studentRepositoryImpl)
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            closeStudentEditPanelUseCase = closeStudentEditPanelUseCase,
            addStudentToStudentTableUseCase = addStudentToStudentTableUseCase,
            openAddStudentPanelUseCase = openAddStudentPanelUseCase,
            saveStudentTableUseCase = saveStudentTableUseCase,
            uploadStudentTableUseCase = uploadStudentTableUseCase,
            adapter = adapter,
            studentList = studentList
        ) as T
    }
}