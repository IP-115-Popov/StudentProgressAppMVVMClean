package com.sergey.studentprogressappmvvmclean.data.storage

import com.sergey.studentprogressappmvvmclean.data.storage.models.StudentForStorage

interface IStudentStorage {
   fun save(saveparam: List<StudentForStorage>):Boolean
   fun get():List<StudentForStorage>
}