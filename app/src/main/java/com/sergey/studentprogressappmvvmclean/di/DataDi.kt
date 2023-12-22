package com.sergey.studentprogressappmvvmclean.di

import com.sergey.studentprogressappmvvmclean.data.repository.StudentRepositoryImpl
import com.sergey.studentprogressappmvvmclean.data.storage.IStudentStorage
import com.sergey.studentprogressappmvvmclean.data.storage.sharedrefs.SharedPrefStudentStorage
import com.sergey.studentprogressappmvvmclean.domain.repository.IStudentRepository
import org.koin.dsl.module

val dataModule = module {
    single<IStudentStorage>
    {
        SharedPrefStudentStorage(context = get(), null)
    }
    single<IStudentRepository>
    {
        StudentRepositoryImpl(studentStorage = get())
    }
}