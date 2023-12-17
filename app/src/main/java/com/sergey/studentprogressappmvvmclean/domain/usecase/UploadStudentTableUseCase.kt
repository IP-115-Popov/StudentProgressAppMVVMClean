package com.sergey.studentprogressappmvvmclean.domain.usecase

import com.sergey.studentprogressappmvvmclean.domain.adapters.IStudentAdapter
import com.sergey.studentprogressappmvvmclean.domain.adapters.IStudentAdapterAddAll
import com.sergey.studentprogressappmvvmclean.domain.models.Student
import com.sergey.studentprogressappmvvmclean.domain.repository.IStudentRepository

class UploadStudentTableUseCase(val adapter: IStudentAdapterAddAll,private val studentRepository: IStudentRepository) {
    fun exectute() :Boolean
    {
        val result = studentRepository.getStudents()
        adapter.addAllStudent(result)
        return true
    }
}