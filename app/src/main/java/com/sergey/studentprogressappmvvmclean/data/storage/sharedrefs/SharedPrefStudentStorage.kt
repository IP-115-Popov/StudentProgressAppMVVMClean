package com.sergey.studentprogressappmvvmclean.data.storage.sharedrefs

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.sergey.studentprogressappmvvmclean.data.storage.IStudentStorage
import com.sergey.studentprogressappmvvmclean.data.storage.models.StudentForStorage

class SharedPrefStudentStorage(val context:Context, val factory: SQLiteDatabase.CursorFactory?):
    IStudentStorage,
    SQLiteOpenHelper(context, "myAppBD", factory, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE students (id INT PRIMARY KEY, fio TEXT, ks1 INT, ks2 INT, ks3 INT, ks4 INT)"
        db!!.execSQL(query);
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS students")
        onCreate(db)
    }
    override fun save(saveparam: List<StudentForStorage>): Boolean {
        var rez: Long = 0
        val db = this.writableDatabase
        for (param in saveparam) {
            val values = ContentValues()
            values.put("fio", param.FIO)
            values.put("ks1", param.KSSubject1)
            values.put("ks2", param.KSSubject2)
            values.put("ks3", param.KSSubject3)
            values.put("ks4", param.KSSubject4)
            rez = db.insert("students", null, values)
        }
        db.close()
        return if (rez == -1L) false else true
    }

    override fun get(): List<StudentForStorage> {
        val arr = mutableListOf<StudentForStorage>() // Инициализация изменяемого списка

        val db = this.readableDatabase
        val result = db.rawQuery("SELECT * FROM students", null)
        while (result.moveToNext()) {
            val fioIndex = result.getColumnIndex("fio")
            val ks1Index = result.getColumnIndex("ks1")
            val ks2Index = result.getColumnIndex("ks2")
            val ks3Index = result.getColumnIndex("ks3")
            val ks4Index = result.getColumnIndex("ks4")
            if (fioIndex >= 0 && ks1Index >= 0 && ks2Index >= 0 && ks3Index >= 0 && ks4Index >= 0) {
                val fio = result.getString(fioIndex)
                val ks1 = result.getInt(ks1Index)
                val ks2 = result.getInt(ks2Index)
                val ks3 = result.getInt(ks3Index)
                val ks4 = result.getInt(ks4Index)

                val student = StudentForStorage(fio, ks1, ks2, ks3, ks4)
                arr.add(student) // Добавление student в список
            }
        }
        result.close() // Закрытие курсора
        return arr
    }
}