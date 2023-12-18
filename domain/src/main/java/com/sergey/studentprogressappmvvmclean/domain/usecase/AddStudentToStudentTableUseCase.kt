package com.sergey.studentprogressappmvvmclean.domain.usecase

import com.sergey.studentprogressappmvvmclean.domain.adapters.IStudentAdapter
import com.sergey.studentprogressappmvvmclean.domain.models.Student

class AddStudentToStudentTableUseCase(val adapter: IStudentAdapter) {
    fun exectute(student: Student)
    {
        adapter.addStudent(student)
    }
}