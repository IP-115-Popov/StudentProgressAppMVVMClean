package com.sergey.studentprogressappmvvmclean.data.storage.models

class StudentForStorage(var FIO:String, var KSSubject1:Int, var KSSubject2:Int, var KSSubject3:Int, var KSSubject4:Int)
{
    var KSAverage:Float = 0.1F
        get() = (KSSubject1+KSSubject2+KSSubject3+KSSubject4)/4.0F
}