package com.sergey.studentprogressappmvvmclean.di

import com.sergey.studentprogressappmvvmclean.domain.usecase.AddStudentToStudentTableUseCase
import com.sergey.studentprogressappmvvmclean.domain.usecase.CloseStudentEditPanelUseCase
import com.sergey.studentprogressappmvvmclean.domain.usecase.OpenAddStudentPanelUseCase
import com.sergey.studentprogressappmvvmclean.domain.usecase.SaveStudentTableUseCase
import com.sergey.studentprogressappmvvmclean.domain.usecase.UploadStudentTableUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<CloseStudentEditPanelUseCase> {
        CloseStudentEditPanelUseCase()
    }
    factory<AddStudentToStudentTableUseCase> {
        AddStudentToStudentTableUseCase(adapter = get())
    }
    factory<OpenAddStudentPanelUseCase> {
        OpenAddStudentPanelUseCase()
    }
    factory<SaveStudentTableUseCase> {
        SaveStudentTableUseCase(studentRepository = get())
    }
    factory<UploadStudentTableUseCase> {
        UploadStudentTableUseCase(adapter = get(), studentRepository = get())
    }
}