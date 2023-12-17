package com.sergey.studentprogressappmvvmclean.data.storage.sharedrefs

import com.sergey.studentprogressappmvvmclean.data.storage.IStudentStorage
import com.sergey.studentprogressappmvvmclean.data.storage.models.StudentForStorage

class SharedPrefStudentStorage: IStudentStorage {
    override fun save(saveparam: List<StudentForStorage>): Boolean {
        return true
    }

    override fun get(): List<StudentForStorage> {
        val arr = listOf<StudentForStorage>()
        return arr
    }
}