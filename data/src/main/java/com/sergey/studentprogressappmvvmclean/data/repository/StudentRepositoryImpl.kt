package com.sergey.studentprogressappmvvmclean.data.repository

import com.sergey.studentprogressappmvvmclean.data.storage.IStudentStorage
import com.sergey.studentprogressappmvvmclean.data.storage.models.StudentForStorage
import com.sergey.studentprogressappmvvmclean.domain.models.Student
import com.sergey.studentprogressappmvvmclean.domain.repository.IStudentRepository

class StudentRepositoryImpl(private val studentStorage: IStudentStorage): IStudentRepository {
    override fun saveStudents(saveparam: List<Student>):Boolean {
        val studentsForStorage = mutableListOf<StudentForStorage>()
        for (student in saveparam)
        {
            studentsForStorage.add(
                StudentForStorage(
                student.FIO,
                student.KSSubject1,
                student.KSSubject2,
                student.KSSubject3,
                student.KSSubject4
            )
            )
        }
        val rezult =  studentStorage.save(studentsForStorage)
        return rezult
    }
    override fun getStudents():List<Student> {
        val rezult = mutableListOf<Student>()

        val studentsForStorage = studentStorage.get()
        for (studentForStorage in studentsForStorage)
        {
            rezult.add(Student(
                studentForStorage.FIO,
                studentForStorage.KSSubject1,
                studentForStorage.KSSubject2,
                studentForStorage.KSSubject3,
                studentForStorage.KSSubject4
            ))
        }
        return rezult
    }
}