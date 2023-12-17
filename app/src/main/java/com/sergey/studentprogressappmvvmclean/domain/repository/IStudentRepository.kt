package com.sergey.studentprogressappmvvmclean.domain.repository

import com.sergey.studentprogressappmvvmclean.domain.models.Student

interface IStudentRepository {
    fun saveStudents(saveparam: List<Student>):Boolean
    fun getStudents():List<Student>
}