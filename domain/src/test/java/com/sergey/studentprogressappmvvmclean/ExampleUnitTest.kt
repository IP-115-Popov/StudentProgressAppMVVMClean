package com.sergey.studentprogressappmvvmclean

import com.sergey.studentprogressappmvvmclean.domain.adapters.IStudentAdapterAddAll
import com.sergey.studentprogressappmvvmclean.domain.models.Student
import com.sergey.studentprogressappmvvmclean.domain.repository.IStudentRepository
import com.sergey.studentprogressappmvvmclean.domain.usecase.SaveStudentTableUseCase
import com.sergey.studentprogressappmvvmclean.domain.usecase.UploadStudentTableUseCase
import org.junit.Test

import org.junit.Assert.*
/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class StudentRepository : IStudentRepository
{
    override fun saveStudents(saveparam: List<Student>): Boolean {
        return true
    }

    override fun getStudents(): List<Student> {
        return  listOf(Student("fio",1,1,1,1))
    }

}
class Adapter : IStudentAdapterAddAll
{
    override fun addAllStudent(student: List<Student>) {

    }

}
class ExampleUnitTest {
    @Test
    fun testUploadStudentTableUseCase() {
        val useCase = SaveStudentTableUseCase(studentRepository = StudentRepository())
        val expected = useCase.exectute(listOf(
            Student("fio",1,1,1,1)
        ))
        assertEquals(true, expected)
    }
    @Test
    fun testSaveStudentTableUseCase() {
        val useCase = UploadStudentTableUseCase(adapter = Adapter(),studentRepository = StudentRepository())
        val expected = useCase.exectute()
        assertEquals(true, expected)
    }
}