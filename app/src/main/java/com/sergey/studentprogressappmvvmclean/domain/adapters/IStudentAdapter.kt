package com.sergey.studentprogressappmvvmclean.domain.adapters

import com.sergey.studentprogressappmvvmclean.domain.models.Student

interface IStudentAdapter {
    fun addStudent(student: Student)
}