package com.sergey.studentprogressappmvvmclean.di

import androidx.recyclerview.widget.RecyclerView
import com.sergey.studentprogressappmvvmclean.data.storage.IStudentStorage
import com.sergey.studentprogressappmvvmclean.data.storage.sharedrefs.SharedPrefStudentStorage
import com.sergey.studentprogressappmvvmclean.domain.adapters.IStudentAdapter
import com.sergey.studentprogressappmvvmclean.domain.adapters.IStudentAdapterAddAll
import com.sergey.studentprogressappmvvmclean.domain.models.Student
import com.sergey.studentprogressappmvvmclean.presentation.Adapters.StudentAdapter
import com.sergey.studentprogressappmvvmclean.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<MutableList<Student>>
    {
        mutableListOf<Student>()
    }
    single<StudentAdapter> {
        StudentAdapter(items = get(), context = get())
    }
    single<IStudentAdapter>
    {
        get<StudentAdapter>()
    }
    single<IStudentAdapterAddAll>
    {
        get<StudentAdapter>()
    }

    viewModel<MainViewModel>{
        MainViewModel(
            closeStudentEditPanelUseCase = get(),
            addStudentToStudentTableUseCase = get(),
            openAddStudentPanelUseCase = get(),
            saveStudentTableUseCase = get(),
            uploadStudentTableUseCase = get(),
            adapter = get(),
            studentList = get()
        )
    }
}