package com.sergey.studentprogressappmvvmclean.domain.usecase

import com.sergey.studentprogressappmvvmclean.domain.models.Student
import com.sergey.studentprogressappmvvmclean.presentation.Adapters.StudentAdapter
import com.sergey.studentprogressappmvvmclean.presentation.Adapters.StudentForAdapter

class AddStudentToStudentTableUseCase(val adapter: StudentAdapter) {
    fun exectute(student: StudentForAdapter)
    {
        adapter.addStudent(student)
    }
}