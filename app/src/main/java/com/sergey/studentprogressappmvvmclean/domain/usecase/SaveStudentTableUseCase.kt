package com.sergey.studentprogressappmvvmclean.domain.usecase

import com.sergey.studentprogressappmvvmclean.domain.models.Student
import com.sergey.studentprogressappmvvmclean.domain.repository.IStudentRepository

class SaveStudentTableUseCase(private val studentRepository: IStudentRepository) {
    fun exectute(saveparam: List<Student>) : Boolean
    {
        val result = studentRepository.saveStudents(saveparam)
        return result
    }
}