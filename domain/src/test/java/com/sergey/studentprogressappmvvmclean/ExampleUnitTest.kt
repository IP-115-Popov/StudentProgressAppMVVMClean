package com.sergey.studentprogressappmvvmclean

import com.sergey.studentprogressappmvvmclean.domain.adapters.IStudentAdapterAddAll
import com.sergey.studentprogressappmvvmclean.domain.models.Student
import com.sergey.studentprogressappmvvmclean.domain.repository.IStudentRepository
import com.sergey.studentprogressappmvvmclean.domain.usecase.SaveStudentTableUseCase
import com.sergey.studentprogressappmvvmclean.domain.usecase.UploadStudentTableUseCase
import org.junit.Test

import org.junit.Assert.*
import org.mockito.kotlin.mock

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
    fun testSaveStudentTableUseCase() {
        val useCase = SaveStudentTableUseCase(studentRepository = StudentRepository())
        val data  = listOf(Student("fio",1,1,1,1))
        val result = useCase.exectute(data)
        val expected = true
        assertEquals(expected, result)
    }
    @Test
    fun testUploadStudentTableUseCase() {
        val useCase = UploadStudentTableUseCase(adapter = Adapter(),studentRepository = StudentRepository())
        val result = useCase.exectute()
        val expected = true
        assertEquals(expected, result)
    }
}