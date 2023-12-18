package com.sergey.studentprogressappmvvmclean.domain.adapters

import com.sergey.studentprogressappmvvmclean.domain.models.Student

interface IStudentAdapterAddAll {
    fun addAllStudent(student: List<Student>)
}